package com.phincon.microservice.notif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;


@Entity
public class Notification {
    @Id
    String id;
    String orderId;
    String status;
    Timestamp createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Notification(String id, String orderId, String status, Timestamp createdDate) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Notification() {
    }
}
