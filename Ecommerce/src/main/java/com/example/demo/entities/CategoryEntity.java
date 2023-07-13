package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

/* This class if for converting the data from database into Category objects */

@Entity
@Table(name = "Category")
public class CategoryEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public CategoryEntity() {

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



    public CategoryEntity(int id, String name, List<ProductEntity> products) {
        this.id = id;
        this.name = name;
    }
}
