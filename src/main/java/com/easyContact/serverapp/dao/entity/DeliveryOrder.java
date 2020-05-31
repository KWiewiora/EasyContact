package com.easyContact.serverapp.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class DeliveryOrder {

    public DeliveryOrder() {
    }

    public DeliveryOrder(Long id, String ware, String quantity, Long fromId, Long toId, LocalDate expectedDeliveryTime, Long executorId, Long principalId) {
        this.id = id;
        this.ware = ware;
        this.quantity = quantity;
        this.fromId = fromId;
        this.toId = toId;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.executorId = executorId;
        this.principalId = principalId;
    }

    @Id
    private Long id;
    private String ware;
    private String quantity;
    private Long fromId;
    private Long toId;
    private Long principalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWare() {
        return ware;
    }

    public void setWare(String ware) {
        this.ware = ware;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public LocalDate getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(LocalDate expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    private LocalDate expectedDeliveryTime;
    private Long executorId;

    public Long getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Long principalId) {
        this.principalId = principalId;
    }
}
