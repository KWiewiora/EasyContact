package com.easyContact.mobileapp.ui.orders.addOrder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.data.servicesModel.OrderRequest;
import com.easyContact.mobileapp.data.servicesModel.OrdersInfo;
import com.easyContact.mobileapp.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class AddOrderActivity extends AppCompatActivity {

    public static String USER_ID = "USER_ID";
    public static String USER_EMAIL = "USER_EMAIL";

    Button button;
    private AddOrderViewModel addOrderViewModel;
    Spinner wareFromSpinner;
    Spinner wareToSpinner;
    EditText wareName;
    EditText quantity;
    OrdersInfo ordersInfo;
    AuthResponse authResponse;
    int userId;
    String email;

    public static Intent prepareIntent(Context context, int userId, String email) {
        Intent intent = new Intent(context, AddOrderActivity.class);
        intent.putExtra(USER_ID, userId);
        intent.putExtra(USER_EMAIL, email);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        addOrderViewModel = new ViewModelProvider(this).get(AddOrderViewModel.class);
        setupExtras();
        setToolbar();
        setupView();
        setupListeners();
    }

    private void setupListeners() {
        button.setOnClickListener(view -> {
            navigateToMain();
        });
    }

    private void setupView() {
        wareFromSpinner = findViewById(R.id.wareFromSpinner);
        wareToSpinner = findViewById(R.id.wareToSpinner);
        button = findViewById(R.id.addOrderButton);
        wareName = findViewById(R.id.inputWare);
        quantity = findViewById(R.id.inputQuantity);
    }

    private void setupExtras() {
        userId = getIntent().getIntExtra(USER_ID, 0);
        email = getIntent().getStringExtra(USER_EMAIL);
        addOrderViewModel.getOrdersInfo().observe(this, ordersInfoResource -> {
            ordersInfo = ordersInfoResource.getResponse();
            setupExtraDataOnView(ordersInfo);
        });
    }

    private void setupExtraDataOnView(OrdersInfo ordersInfo) {
        List<String> wareNameFromList = ordersInfo.getWareNames().stream().map(OrdersInfo.WareNames::getName).collect(Collectors.toList());
        List<String> wareNameToList = new ArrayList<>(wareNameFromList);
        Collections.reverse(wareNameToList);
        wareFromSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, wareNameFromList));
        wareToSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, wareNameToList));
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    private OrderRequest prepareRequest() {
        return new OrderRequest.OrderRequestBuilder()
                .ware(wareName.getText().toString())
                .quantity(quantity.getText().toString())
                .fromId(Objects.requireNonNull(getWareIdByName(wareFromSpinner)))
                .toId(Objects.requireNonNull(getWareIdByName(wareToSpinner)))
                .principalId(userId)
                .executorId(null)
                .build();
    }

    private void navigateToMain() {
        addOrderViewModel.addOrder(prepareRequest(), email).observe(this, authResponseResource -> {
            authResponse = authResponseResource.getResponse();
            authResponse.getUserInfo().setEmail(email);
            startActivity(MainActivity.prepareIntent(this, authResponse));
        });
    }


    private Integer getWareIdByName(Spinner spinner) {
        Optional<OrdersInfo.WareNames> wareName = ordersInfo.getWareNames().stream().filter((name) -> name.getName().equals(spinner.getSelectedItem().toString())).findFirst();
        if (wareName.isPresent()) {
            return wareName.get().getId();
        }
        return null;
    }
}
