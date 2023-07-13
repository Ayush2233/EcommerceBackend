package com.example.demo.entities;

import jakarta.persistence.*;

/* This class if for converting the data from database into Country objects */

@Entity
@Table(name = "Country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phoneCode;

    public CountryEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public CountryEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "CountryEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", phoneCode='" + phoneCode + '\'' +
//                '}';
//    }
}
