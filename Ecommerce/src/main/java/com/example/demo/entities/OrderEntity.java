package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/* This class if for converting the data from database into Order objects */

@Entity
@Table(name = "Orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "USER_ORDER",
            joinColumns = {
                    @JoinColumn(name = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "p_id")
            }
    )
    private List<ProductEntity> product;

    @Column
    private OrderStatus orderStatus;

    @OneToOne
//    @JoinColumn(name="deliveryId",referencedColumnName = "id")
    private DeliveryEntity delivery;

    @ManyToOne
//    @JoinColumn(name = "buyerID",referencedColumnName = "id")
    private UserEntity user;

    private String address;

    private int paymentAmount;

    private LocalDateTime orderDate;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public DeliveryEntity getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryEntity delivery) {
        this.delivery = delivery;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderEntity(int id, List<ProductEntity> product, OrderStatus orderStatus, DeliveryEntity delivery, UserEntity user, String address, int paymentAmount, LocalDateTime orderDate) {
        this.id = id;
        this.product = product;
        this.orderStatus = orderStatus;
        this.delivery = delivery;
        this.user = user;
        this.address = address;
        this.paymentAmount = paymentAmount;
        this.orderDate = orderDate;
    }
}
