package com.easyContact.mobileapp.ui.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.ui.orders.OrdersFragment;
import com.easyContact.mobileapp.ui.orders.addOrder.AddOrderActivity;
import com.easyContact.mobileapp.ui.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    public static String AUTH_RESPONSE = "AUTH_RESPONSE";

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    public AuthResponse authResponse;

    public static Intent prepareIntent(Context context, AuthResponse authResponse) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(AUTH_RESPONSE, authResponse);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authResponse = getIntent().getParcelableExtra(AUTH_RESPONSE);
        setupViews();
        setupListeners();
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new OrdersFragment()).commit();
    }

    private void setupListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onClickBottomNav);
    }

    private void setupViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    private boolean onClickBottomNav(MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.ordersFragment:
                selectedFragment = new OrdersFragment();
                break;
            case R.id.userFragment:
                selectedFragment = new UserFragment();
        }
        assert selectedFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if (isUserSupply()) {
            inflater.inflate(R.menu.add_order_menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addOrder && isUserSupply()) {
            navigateToAddOrder();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isUserSupply() {
        return authResponse.getUserInfo().getUserType().equals("PRINCIPAL");
    }

    private void navigateToAddOrder() {
        startActivity(AddOrderActivity.prepareIntent(this, authResponse.getUserInfo().getId(), authResponse.getUserInfo().getEmail()));
    }

    @Override
    public void onBackPressed() {
        areYouSureDialog((dialogInterface, i) -> onExitAction());
    }

    private void onExitAction() {
        this.finishAffinity();
    }

    void areYouSureDialog(DialogInterface.OnClickListener callback) {
        new MaterialAlertDialogBuilder(this, R.style.MainDialogStyle)
                .setTitle(R.string.are_you_sure)
                .setNegativeButton(R.string.text_cancel, null)
                .setPositiveButton(R.string.text_yes, callback)
                .show();
    }
}
