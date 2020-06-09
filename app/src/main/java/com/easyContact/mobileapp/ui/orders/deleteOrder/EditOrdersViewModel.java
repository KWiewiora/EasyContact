package com.easyContact.mobileapp.ui.orders.deleteOrder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.easyContact.mobileapp.data.repository.OrdersRepository;
import com.easyContact.mobileapp.data.repository.Resource;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;

public class EditOrdersViewModel extends ViewModel {

    public EditOrdersViewModel() {
        init();
    }

    private MutableLiveData<Resource<AuthResponse>> ordersResponseLiveData;
    private MutableLiveData<Resource<AuthResponse>> updateContentData;


    private OrdersRepository ordersRepository;

    public void init() {
        this.ordersResponseLiveData = new MutableLiveData<>();
        ordersRepository = OrdersRepository.getInstance();
    }

    public LiveData<Resource<AuthResponse>> deleteOrder(String email, int orderId) {
        ordersResponseLiveData = ordersRepository.deleteOrder(orderId, email);
        return ordersResponseLiveData;
    }


    public LiveData<Resource<AuthResponse>> updateOrder(Integer orderId, Integer executorId, String email) {
        updateContentData = ordersRepository.updateOrder(orderId, executorId, email);
        return updateContentData;
    }
}
