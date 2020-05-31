package com.easyContact.mobileapp.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.easyContact.mobileapp.data.repository.AuthRepository;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;

public class AuthViewModel extends ViewModel {

    public AuthViewModel() {
        init();
    }

    private MutableLiveData<AuthResponse> authResponseMutableLiveData;

    private AuthRepository authRepository;

    public void init() {
        this.authResponseMutableLiveData = new MutableLiveData<>();
        authRepository = AuthRepository.getInstance();
    }

    public LiveData<AuthResponse> getLoginResponse(String email, String password) {
        authResponseMutableLiveData = authRepository.getLoginResponse(email, password);
        return authResponseMutableLiveData;
    }

    public LiveData<AuthResponse> getRegisterResponse(String email, String password) {
        authResponseMutableLiveData = authRepository.getRegisterResponse(email, password);
        return authResponseMutableLiveData;
    }

}
