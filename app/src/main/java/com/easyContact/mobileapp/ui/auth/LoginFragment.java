package com.easyContact.mobileapp.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.repository.Resource;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.ui.main.MainActivity;


public class LoginFragment extends Fragment {

    Button loginButton;
    Button registerButton;
    private AuthViewModel authViewModel;
    private EditText email;
    private EditText password;

    public LoginFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        setupViews(view);
        setupListeners();

    }

    private void setupViews(View view) {
        email = view.findViewById(R.id.inputLogin);
        password = view.findViewById(R.id.inputPassword);
        loginButton = view.findViewById(R.id.loginButton);

    }

    private void setupListeners() {
        loginButton.setOnClickListener(view -> login());
//        registerButton.setOnClickListener(view -> navigateToRegister());
    }

    private void navigateToRegister() {
        // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.auth_fragments_container, Register)
    }

    private void login() {
        authViewModel.init();
        authViewModel.getLoginResponse(email.getText().toString(), password.getText().toString()).observe(getViewLifecycleOwner(), authResponseResource -> validateResponse(authResponseResource, email.getText().toString()));
    }

    private void validateResponse(Resource<AuthResponse> authResource, String email) {
        if (!authResource.isSuccessfull()) {
            showToastAndCleanView();
        } else {
            authResource.getResponse().getUserInfo().setEmail(email);
            startActivity(MainActivity.prepareIntent(getContext(), authResource.getResponse()));
        }
    }

    private void showToastAndCleanView() {
        Toast.makeText(getContext(), "Nie znaleziono uzytkownika", Toast.LENGTH_LONG).show();
        email.setText("");
        password.setText("");
        password.setSelected(false);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}
