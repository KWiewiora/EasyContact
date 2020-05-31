package com.easyContact.mobileapp.data.servicesModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class AuthResponse implements Parcelable {
    private final UserInfo userInfo;

    private final List<DeliveryOrders> deliveryOrders;

    public AuthResponse(UserInfo userInfo, List<DeliveryOrders> deliveryOrders) {
        this.userInfo = userInfo;
        this.deliveryOrders = deliveryOrders;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public List<DeliveryOrders> getDeliveryOrders() {
        return deliveryOrders;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

    public static class DeliveryOrders implements Parcelable {
        private final int id;

        private final String ware;

        private final String quantity;

        private final int fromId;

        private final int toId;

        private final int principalId;

        private final String expectedDeliveryTime;

        private final int executorId;

        public DeliveryOrders(int id, String ware, String quantity, int fromId, int toId,
                              int principalId, String expectedDeliveryTime, int executorId) {
            this.id = id;
            this.ware = ware;
            this.quantity = quantity;
            this.fromId = fromId;
            this.toId = toId;
            this.principalId = principalId;
            this.expectedDeliveryTime = expectedDeliveryTime;
            this.executorId = executorId;
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

        public int getFromId() {
            return fromId;
        }

        public int getToId() {
            return toId;
        }

        public int getPrincipalId() {
            return principalId;
        }

        public String getExpectedDeliveryTime() {
            return expectedDeliveryTime;
        }

        public int getExecutorId() {
            return executorId;
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
            dest.writeInt(this.fromId);
            dest.writeInt(this.toId);
            dest.writeInt(this.principalId);
            dest.writeString(this.expectedDeliveryTime);
            dest.writeInt(this.executorId);
        }

        protected DeliveryOrders(Parcel in) {
            this.id = in.readInt();
            this.ware = in.readString();
            this.quantity = in.readString();
            this.fromId = in.readInt();
            this.toId = in.readInt();
            this.principalId = in.readInt();
            this.expectedDeliveryTime = in.readString();
            this.executorId = in.readInt();
        }

        public static final Creator<DeliveryOrders> CREATOR = new Creator<DeliveryOrders>() {
            @Override
            public DeliveryOrders createFromParcel(Parcel source) {
                return new DeliveryOrders(source);
            }

            @Override
            public DeliveryOrders[] newArray(int size) {
                return new DeliveryOrders[size];
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
        dest.writeList(this.deliveryOrders);
    }

    protected AuthResponse(Parcel in) {
        this.userInfo = in.readParcelable(UserInfo.class.getClassLoader());
        this.deliveryOrders = new ArrayList<DeliveryOrders>();
        in.readList(this.deliveryOrders, DeliveryOrders.class.getClassLoader());
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
