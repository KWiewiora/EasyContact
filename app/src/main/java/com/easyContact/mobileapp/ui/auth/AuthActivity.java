package com.easyContact.mobileapp.ui.auth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.easyContact.mobileapp.R;

public class AuthActivity extends AppCompatActivity {


    public AuthViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().add(R.id.auth_fragments_container, new LoginFragment()).commit();
        setContentView(R.layout.activity_auth);

    }



    private void navigateToRegister() {
        //getSupportFragmentManager().beginTransaction().replace(R.id.auth_fragments_container, new )
    }

    private void login() {

    }



}
