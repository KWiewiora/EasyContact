
package com.easyContact.serverapp.models;

import java.time.LocalDate;

public class Order {
    private Long id;
    private String ware;
    private String quantity;
    private String wareFromName;
    private String wareToName;
    private String principalName;
    private LocalDate deliveryDate;
    private String executorName;


    public Order(Long id, String ware, String quantity, String wareFromName, String wareToName, String principalName, LocalDate deliveryDate, String executorName) {
        this.id = id;
        this.ware = ware;
        this.quantity = quantity;
        this.wareFromName = wareFromName;
        this.wareToName = wareToName;
        this.principalName = principalName;
        this.deliveryDate = deliveryDate;
        this.executorName = executorName;
    }

    public static Order.OrderBuilder builder() {
        return new Order.OrderBuilder();
    }

    public String getWare() {
        return this.ware;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getWareFromName() {
        return this.wareFromName;
    }

    public String getWareToName() {
        return this.wareToName;
    }

    public String getPrincipalName() {
        return this.principalName;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public String getExecutorName() {
        return this.executorName;
    }

    public void setWare(final String ware) {
        this.ware = ware;
    }

    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    public void setWareFromName(final String wareFromName) {
        this.wareFromName = wareFromName;
    }

    public void setWareToName(final String wareToName) {
        this.wareToName = wareToName;
    }

    public void setPrincipalName(final String principalName) {
        this.principalName = principalName;
    }

    public void setDeliveryDate(final LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setExecutorName(final String executorName) {
        this.executorName = executorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Order)) {
            return false;
        } else {
            Order other = (Order) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95:
                {
                    Object this$ware = this.getWare();
                    Object other$ware = other.getWare();
                    if (this$ware == null) {
                        if (other$ware == null) {
                            break label95;
                        }
                    } else if (this$ware.equals(other$ware)) {
                        break label95;
                    }

                    return false;
                }

                Object this$quantity = this.getQuantity();
                Object other$quantity = other.getQuantity();
                if (this$quantity == null) {
                    if (other$quantity != null) {
                        return false;
                    }
                } else if (!this$quantity.equals(other$quantity)) {
                    return false;
                }

                Object this$wareFromName = this.getWareFromName();
                Object other$wareFromName = other.getWareFromName();
                if (this$wareFromName == null) {
                    if (other$wareFromName != null) {
                        return false;
                    }
                } else if (!this$wareFromName.equals(other$wareFromName)) {
                    return false;
                }

                label74:
                {
                    Object this$wareToName = this.getWareToName();
                    Object other$wareToName = other.getWareToName();
                    if (this$wareToName == null) {
                        if (other$wareToName == null) {
                            break label74;
                        }
                    } else if (this$wareToName.equals(other$wareToName)) {
                        break label74;
                    }

                    return false;
                }

                label67:
                {
                    Object this$principalName = this.getPrincipalName();
                    Object other$principalName = other.getPrincipalName();
                    if (this$principalName == null) {
                        if (other$principalName == null) {
                            break label67;
                        }
                    } else if (this$principalName.equals(other$principalName)) {
                        break label67;
                    }

                    return false;
                }

                Object this$deliveryDate = this.getDeliveryDate();
                Object other$deliveryDate = other.getDeliveryDate();
                if (this$deliveryDate == null) {
                    if (other$deliveryDate != null) {
                        return false;
                    }
                } else if (!this$deliveryDate.equals(other$deliveryDate)) {
                    return false;
                }

                Object this$executorName = this.getExecutorName();
                Object other$executorName = other.getExecutorName();
                if (this$executorName == null) {
                    if (other$executorName != null) {
                        return false;
                    }
                } else if (!this$executorName.equals(other$executorName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }


    public String toString() {
        String var10000 = this.getWare();
        return "Order(ware=" + var10000 + ", quantity=" + this.getQuantity() + ", wareFromName=" + this.getWareFromName() + ", wareToName=" + this.getWareToName() + ", principalName=" + this.getPrincipalName() + ", deliveryDate=" + this.getDeliveryDate() + ", executorName=" + this.getExecutorName() + ")";
    }

    public static class OrderBuilder {

        private Long id;
        private String ware;
        private String quantity;
        private String wareFromName;
        private String wareToName;
        private String principalName;
        private LocalDate deliveryDate;
        private String executorName;

        public OrderBuilder() {
        }

        public Order.OrderBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public Order.OrderBuilder ware(final String ware) {
            this.ware = ware;
            return this;
        }

        public Order.OrderBuilder quantity(final String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Order.OrderBuilder wareFromName(final String wareFromName) {
            this.wareFromName = wareFromName;
            return this;
        }

        public Order.OrderBuilder wareToName(final String wareToName) {
            this.wareToName = wareToName;
            return this;
        }

        public Order.OrderBuilder principalName(final String principalName) {
            this.principalName = principalName;
            return this;
        }

        public Order.OrderBuilder deliveryDate(final LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Order.OrderBuilder executorName(final String executorName) {
            this.executorName = executorName;
            return this;
        }

        public Order build() {
            return new Order(this.id, this.ware, this.quantity, this.wareFromName, this.wareToName, this.principalName, this.deliveryDate, this.executorName);
        }

        public String toString() {
            return "Order.OrderBuilder(ware=" + this.ware + ", quantity=" + this.quantity + ", wareFromName=" + this.wareFromName + ", wareToName=" + this.wareToName + ", principalName=" + this.principalName + ", deliveryDate=" + this.deliveryDate + ", executorName=" + this.executorName + ")";
        }
    }
}
