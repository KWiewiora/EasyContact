package com.easyContact.mobileapp.ui.auth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.easyContact.mobileapp.R;

public class AuthActivity extends AppCompatActivity {


    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().add(R.id.auth_fragments_container, new LoginFragment()).commit();
        setContentView(R.layout.activity_auth);
        setupToolbar();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    private void navigateToRegister() {
        //getSupportFragmentManager().beginTransaction().replace(R.id.auth_fragments_container, new )
    }
}
