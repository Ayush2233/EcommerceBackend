package com.example.demo.services;


import com.example.demo.dto.CartDto;
import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.entities.UserEntity;

import java.util.List;

/*This is the service interface where all the methods related to User table are defined*/
public interface UserService {

    UserEntity findByEmail(String email);

    void addUser(UserEntity user , String city , String state,int role);

//    void addtoCart(String userid,int productid);
    void addtoCart(int userid,int productid);

    void deleteCart(int userid,int productid);

    List<CartDto> getCart(int userid);


    UserEntity getUser(int userId);

    void deleteUser(int userId);

    List<String> getAllEmail();

    List<String> getAllPhone();

    String changePassword(ChangePasswordDto changePasswordDto);



}
