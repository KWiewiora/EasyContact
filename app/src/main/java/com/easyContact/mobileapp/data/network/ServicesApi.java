package com.easyContact.mobileapp.data.network;

import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.data.servicesModel.AuthRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServicesApi {

    @POST("signIn")
    Call<AuthResponse> login(@Body AuthRequest authRequest);

    @POST("signUp")
    Call<AuthResponse> register(@Body  AuthRequest authRequest);
}
