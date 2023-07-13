package com.example.demo.dto;

import com.example.demo.entities.ProductEntity;


public class CartDto {

    private ProductEntity productEntity;

    private long quantity;

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public CartDto(ProductEntity productEntity, long quantity) {
        this.productEntity = productEntity;
        this.quantity = quantity;
    }

    public CartDto() {
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "productEntity=" + productEntity +
                ", quantity=" + quantity +
                '}';
    }
}
