package com.example.demo.dto;

import com.example.demo.entities.AddressEntity;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.UserEntity;

import java.util.Set;

public class AuthResponse {

    private String Token;

    private int userId;

    private String userName;

    private AddressEntity userAddress;

    private long phone;
    private Set<RoleEntity> role;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AddressEntity getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(AddressEntity userAddress) {
        this.userAddress = userAddress;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }



    public String getToken() {
        return Token;
    }

    public Set<RoleEntity> getRole() {
        return role;
    }

    public void setRole(Set<RoleEntity> role) {
        this.role = role;
    }

    public void setToken(String token) {
        Token = token;
    }

    public AuthResponse(String token, Set<RoleEntity> role) {
        Token = token;
        this.role = role;
    }

    public  AuthResponse(UserEntity userEntity,String token)
    {
        this.role=userEntity.getRole();
        this.Token=token;
        this.phone=userEntity.getPhone();
        this.userId=userEntity.getId();
        this.userName=userEntity.getName();
        this.userAddress=userEntity.getAddress();

    }
    public  AuthResponse()
    {

    }
//
//    public UserEntity getUserEntity() {
//        return userEntity;
//    }
//
//    public void setUserEntity(UserEntity userEntity) {
//        this.userEntity = userEntity;
//    }
//


//    public Set<RoleEntity> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<RoleEntity> role) {
//        this.role = role;
//    }
//
//    public AuthResponse(String token, Set<RoleEntity> role) {
//        Token = token;
//        this.role = role;
//    }

}
