

package com.easyContact.serverapp.models;

import java.util.ArrayList;
import java.util.List;

public class OrdersInfo {
    private List<EntityOrderInfo> wareNames;
    private List<EntityOrderInfo> executorsNames;
    private List<EntityOrderInfo> principalNames;

    public OrdersInfo() {
        this.wareNames = new ArrayList<>();
        this.executorsNames = new ArrayList<>();
        this.principalNames = new ArrayList<>();
    }

    public List<EntityOrderInfo> getWareNames() {
        return this.wareNames;
    }

    public List<EntityOrderInfo> getExecutorsNames() {
        return this.executorsNames;
    }

    public List<EntityOrderInfo> getPrincipalNames() {
        return this.principalNames;
    }

    public void setWareNames(final List<EntityOrderInfo> wareNames) {
        this.wareNames = wareNames;
    }

    public void setExecutorsNames(final List<EntityOrderInfo> executorsNames) {
        this.executorsNames = executorsNames;
    }

    public void setPrincipalNames(final List<EntityOrderInfo> principalNames) {
        this.principalNames = principalNames;
    }


}
