package com.easyContact.mobileapp.data.servicesModel;

public class OrderRequest {
    private String ware;

    private String quantity;

    private int fromId;

    private int toId;

    private int principalId;

    private String expectedDeliveryTime;

    private Integer executorId;

    public OrderRequest(String ware, String quantity, int fromId, int toId, int principalId,
                        String expectedDeliveryTime, Integer executorId) {
        this.ware = ware;
        this.quantity = quantity;
        this.fromId = fromId;
        this.toId = toId;
        this.principalId = principalId;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.executorId = executorId;
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

    public Integer getExecutorId() {
        return executorId;
    }


    public static OrderRequest.OrderRequestBuilder builder() {
        return new OrderRequest.OrderRequestBuilder();
    }

    public static class OrderRequestBuilder {
        private String ware;
        private String quantity;
        private int fromId;
        private int toId;
        private int principalId;
        private String expectedDeliveryTime;
        private Integer executorId;

        public OrderRequestBuilder() {
        }

        public OrderRequest.OrderRequestBuilder ware(String ware) {
            this.ware = ware;
            return this;
        }

        public OrderRequest.OrderRequestBuilder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderRequest.OrderRequestBuilder fromId(int fromId) {
            this.fromId = fromId;
            return this;
        }

        public OrderRequest.OrderRequestBuilder toId(int toId) {
            this.toId = toId;
            return this;
        }

        public OrderRequest.OrderRequestBuilder principalId(int principalId) {
            this.principalId = principalId;
            return this;
        }

        public OrderRequest.OrderRequestBuilder expectedDeliveryDate(String expectedDeliveryDate) {
            this.expectedDeliveryTime = expectedDeliveryDate;
            return this;
        }

        public OrderRequest.OrderRequestBuilder executorId(Integer executorId) {
            this.executorId = executorId;
            return this;
        }

        public OrderRequest build() {
            return new OrderRequest(this.ware, this.quantity, this.fromId, this.toId, this.principalId, this.expectedDeliveryTime, this.executorId);
        }
    }
}
