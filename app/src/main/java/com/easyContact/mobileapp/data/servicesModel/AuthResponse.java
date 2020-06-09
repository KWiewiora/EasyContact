package com.easyContact.mobileapp.data.servicesModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class AuthResponse implements Parcelable {
    private final UserInfo userInfo;

    private final List<Orders> orders;

    public AuthResponse(UserInfo userInfo, List<Orders> orders) {
        this.userInfo = userInfo;
        this.orders = orders;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public static class UserInfo implements Parcelable {
        private final int id;

        private final String name;

        private final String address;

        private final String phoneNumber;

        private final int userId;

        private final String userType;

        private String email;

        public UserInfo(int id, String name, String address, String phoneNumber, int userId,
                        String userType, String email) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.userId = userId;
            this.userType = userType;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public int getUserId() {
            return userId;
        }

        public String getUserType() {
            return userType;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeString(this.address);
            dest.writeString(this.phoneNumber);
            dest.writeInt(this.userId);
            dest.writeString(this.userType);
            dest.writeString(this.email);
        }

        protected UserInfo(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.address = in.readString();
            this.phoneNumber = in.readString();
            this.userId = in.readInt();
            this.userType = in.readString();
            this.email = in.readString();
        }

        public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
            @Override
            public UserInfo createFromParcel(Parcel source) {
                return new UserInfo(source);
            }

            @Override
            public UserInfo[] newArray(int size) {
                return new UserInfo[size];
            }
        };
    }

    public static class Orders implements Parcelable {
        private final int id;

        private final String ware;

        private final String quantity;

        private final String wareFromName;

        private final String wareToName;

        private final String principalName;

        private final String deliveryDate;

        private final String executorName;

        public Orders(int id, String ware, String quantity, String wareFromName, String wareToName,
                      String principalName, String deliveryDate, String executorName) {
            this.id = id;
            this.ware = ware;
            this.quantity = quantity;
            this.wareFromName = wareFromName;
            this.wareToName = wareToName;
            this.principalName = principalName;
            this.deliveryDate = deliveryDate;
            this.executorName = executorName;
        }

        public int getId() {
            return id;
        }

        public String getWare() {
            return ware;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getWareFromName() {
            return wareFromName;
        }

        public String getWareToName() {
            return wareToName;
        }

        public String getPrincipalName() {
            return principalName;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public String getExecutorName() {
            return executorName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.ware);
            dest.writeString(this.quantity);
            dest.writeString(this.wareFromName);
            dest.writeString(this.wareToName);
            dest.writeString(this.principalName);
            dest.writeString(this.deliveryDate);
            dest.writeString(this.executorName);
        }

        protected Orders(Parcel in) {
            this.id = in.readInt();
            this.ware = in.readString();
            this.quantity = in.readString();
            this.wareFromName = in.readString();
            this.wareToName = in.readString();
            this.principalName = in.readString();
            this.deliveryDate = in.readString();
            this.executorName = in.readString();
        }

        public static final Creator<Orders> CREATOR = new Creator<Orders>() {
            @Override
            public Orders createFromParcel(Parcel source) {
                return new Orders(source);
            }

            @Override
            public Orders[] newArray(int size) {
                return new Orders[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.userInfo, flags);
        dest.writeList(this.orders);
    }

    protected AuthResponse(Parcel in) {
        this.userInfo = in.readParcelable(UserInfo.class.getClassLoader());
        this.orders = new ArrayList<Orders>();
        in.readList(this.orders, Orders.class.getClassLoader());
    }

    public static final Parcelable.Creator<AuthResponse> CREATOR = new Parcelable.Creator<AuthResponse>() {
        @Override
        public AuthResponse createFromParcel(Parcel source) {
            return new AuthResponse(source);
        }

        @Override
        public AuthResponse[] newArray(int size) {
            return new AuthResponse[size];
        }
    };
}
