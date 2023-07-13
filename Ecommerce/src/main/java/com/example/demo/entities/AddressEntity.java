package com.example.demo.entities;

import jakarta.persistence.*;

/* This class if for converting the data from database into Address objects */



@Entity
@Table(name = "Address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "stateAndCityId",referencedColumnName = "id")
    private StateCityEntity stateCity;

    public AddressEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StateCityEntity getStateCity() {
        return stateCity;
    }

    public void setStateCity(StateCityEntity stateCity) {
        this.stateCity = stateCity;
    }

    public AddressEntity(int id, String address, StateCityEntity stateCity) {
        this.id = id;
        this.address = address;
        this.stateCity = stateCity;
    }

//    @Override
//    public String toString() {
//        return "AddressEntity{" +
//                "id=" + id +
//                ", address='" + address + '\'' +
//                ", stateCity=" + stateCity +
//                '}';
//    }
}
