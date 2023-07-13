package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/* This class if for converting the data from database into Delivery objects */

@Entity
@Table(name = "Delivery")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime expectedDeliveryDate;
    private LocalDateTime deliveryDate;

    private boolean isDelivered;

    public DeliveryEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public LocalDateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDateTime expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public DeliveryEntity(int id, LocalDateTime expectedDeliveryDate, LocalDateTime deliveryDate, boolean isDelivered) {
        this.id = id;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.isDelivered = isDelivered;
    }
}
