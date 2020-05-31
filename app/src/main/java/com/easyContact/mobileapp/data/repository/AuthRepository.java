package com.easyContact.mobileapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.easyContact.mobileapp.data.network.NetworkController;
import com.easyContact.mobileapp.data.network.ServicesApi;
import com.easyContact.mobileapp.data.servicesModel.AuthRequest;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;

public class AuthRepository extends BaseRepository {

    private static AuthRepository authRepository;
    private ServicesApi servicesApi;

    public static AuthRepository getInstance() {
        if (authRepository == null) {
            authRepository = new AuthRepository();
        }
        return authRepository;
    }

    AuthRepository() {
        servicesApi = NetworkController.createService(ServicesApi.class);
    }

    public MutableLiveData<AuthResponse> getLoginResponse(String email, String password) {
        MutableLiveData<AuthResponse> authResponseMutableLiveData;
        AuthRequest authRequest = new AuthRequest(email, password);
        authResponseMutableLiveData = new Repository<AuthResponse>().getData(servicesApi.login(authRequest));
        return authResponseMutableLiveData;
    }

    public MutableLiveData<AuthResponse> getRegisterResponse(String email, String password) {
        MutableLiveData<AuthResponse> authResponseMutableLiveData;
        AuthRequest authRequest = new AuthRequest(email, password);
        authResponseMutableLiveData = new Repository<AuthResponse>().getData(servicesApi.register(authRequest));
        return authResponseMutableLiveData;
    }
}
