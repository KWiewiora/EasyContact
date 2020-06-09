package com.easyContact.mobileapp.data.network;

import com.easyContact.mobileapp.data.servicesModel.AuthRequest;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.data.servicesModel.OrderRequest;
import com.easyContact.mobileapp.data.servicesModel.OrdersInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServicesApi {

    @POST("signIn")
    Call<AuthResponse> login(@Body AuthRequest authRequest);

    @POST("signUp")
    Call<AuthResponse> register(@Body AuthRequest authRequest);

    @DELETE("deleteDeliveryOrder")
    Call<AuthResponse> deleteOrder(@Query("deliveryOrderId") int orderId, @Query("email") String email);

    @POST("insertDeliveryOrder")
    Call<AuthResponse> addOrder(@Body OrderRequest orderRequest, @Query("email") String email);

    @GET("getOrdersInfo")
    Call<OrdersInfo> getOrdersInfo();

    @PATCH("updateDeliveryOrder")
    Call<AuthResponse> updateDeliveryOrder(@Query("orderId") int orderId, @Query("executorId") int executorId, @Query("email") String email);
}
