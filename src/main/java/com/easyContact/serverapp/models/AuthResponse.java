package com.raddyr.serverapp.models;

import com.raddyr.serverapp.dao.entity.UserInfo;

import java.util.List;

public class AuthResponse {

    public AuthResponse() {
    }

    public AuthResponse(UserInfo userInfo, List<Order> orders) {
        this.userInfo = userInfo;
        this.orders = orders;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    private UserInfo userInfo;
    private List<Order> orders;

}
