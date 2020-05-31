package com.easyContact.mobileapp.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkController {

    //private static final String BASE_URL = "http://192.168.0.129:8080/api/";
    private static final String BASE_URL = "http://10.0.2.2:8080/api/";

    public static <S> S createService(Class<S> serviceClass) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(serviceClass);
    }

}
