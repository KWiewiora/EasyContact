package com.easyContact.serverapp.dao.entity;

public interface UserInfo {
      Long  id = null;
      String name = null;
     String address = null;
     String phoneNumber = null;
     Long userId = null;
     String userType = null;

     void setUserType(String userType);
     String getUserType();
     Long getId();
}
