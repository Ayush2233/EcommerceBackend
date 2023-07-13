package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

/* This class if for converting the data from database into Role objects */

@Entity
@Table(name = "Role")
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String role;


    public RoleEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }





    public RoleEntity(int id, String role, List<UserEntity> users) {
        this.id = id;
        this.role = role;
    }
//
//    @Override
//    public String toString() {
//        return "RoleEntity{" +
//                "id=" + id +
//                ", role='" + role + '\'' +
//                ", users=" + users +
//                '}';
//    }
}
