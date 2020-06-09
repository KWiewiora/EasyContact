package com.easyContact.mobileapp.ui.orders.addOrder;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.easyContact.mobileapp.data.repository.OrdersRepository;
import com.easyContact.mobileapp.data.repository.Resource;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.data.servicesModel.OrderRequest;
import com.easyContact.mobileapp.data.servicesModel.OrdersInfo;

public class AddOrderViewModel extends ViewModel {

    public AddOrderViewModel() {
        init();
    }

    private MutableLiveData<Resource<AuthResponse>> addOrderResponseData;
    private MutableLiveData<Resource<OrdersInfo>> ordersInfoData;
    private OrdersRepository ordersRepository;

    public void init() {
        this.addOrderResponseData = new MutableLiveData<>();
        ordersRepository = OrdersRepository.getInstance();
    }

    public LiveData<Resource<AuthResponse>> addOrder(OrderRequest orderRequest, String email) {
        addOrderResponseData = ordersRepository.addOrder(orderRequest, email);
        return addOrderResponseData;
    }

    public LiveData<Resource<OrdersInfo>> getOrdersInfo() {
        ordersInfoData = ordersRepository.getOrdersInfo();
        return ordersInfoData;
    }
}