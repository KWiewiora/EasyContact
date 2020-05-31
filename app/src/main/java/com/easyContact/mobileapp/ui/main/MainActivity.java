package com.easyContact.mobileapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.ui.orders.OrdersFragment;
import com.easyContact.mobileapp.ui.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static String AUTH_RESPONSE = "AUTH_RESPONSE";

    BottomNavigationView bottomNavigationView;
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
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
        return true;

    }
}
