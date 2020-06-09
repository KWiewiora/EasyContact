package com.easyContact.mobileapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.easyContact.mobileapp.data.network.NetworkController;
import com.easyContact.mobileapp.data.network.ServicesApi;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.data.servicesModel.OrderRequest;
import com.easyContact.mobileapp.data.servicesModel.OrdersInfo;

public class OrdersRepository extends BaseRepository {

    private static OrdersRepository ordersRepository;
    private ServicesApi servicesApi;

    public static OrdersRepository getInstance() {
        if (ordersRepository == null) {
            ordersRepository = new OrdersRepository();
        }
        return ordersRepository;
    }

    OrdersRepository() {
        servicesApi = NetworkController.createService(ServicesApi.class);
    }

    public MutableLiveData<Resource<AuthResponse>> deleteOrder(int orderId, String email) {
        MutableLiveData<Resource<AuthResponse>> authResponseMutableLiveData;
        authResponseMutableLiveData = new BaseRepository<AuthResponse>().getData(servicesApi.deleteOrder(orderId, email));
        return authResponseMutableLiveData;
    }

    public MutableLiveData<Resource<AuthResponse>> addOrder(OrderRequest orderRequest, String email) {
        MutableLiveData<Resource<AuthResponse>> authResponseMutableLiveData;
        authResponseMutableLiveData = new BaseRepository<AuthResponse>().getData(servicesApi.addOrder(orderRequest, email));
        return authResponseMutableLiveData;
    }

    public MutableLiveData<Resource<OrdersInfo>> getOrdersInfo() {
        MutableLiveData<Resource<OrdersInfo>> ordersInfoMutableLiveData;
        ordersInfoMutableLiveData = new BaseRepository<OrdersInfo>().getData(servicesApi.getOrdersInfo());
        return ordersInfoMutableLiveData;
    }

    public MutableLiveData<Resource<AuthResponse>> updateOrder(Integer orderId, Integer executorId, String email) {
        MutableLiveData<Resource<AuthResponse>> ordersInfoMutableLiveData;
        ordersInfoMutableLiveData = new BaseRepository<AuthResponse>().getData(servicesApi.updateDeliveryOrder(orderId, executorId, email));
        return ordersInfoMutableLiveData;
    }
}
