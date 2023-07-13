package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.entities.UserEntity;
import com.example.demo.servicesImpl.JwtServiceImpl;
import com.example.demo.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This a User Controller class which has all the url endpoints related to user related services


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200/**")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody UserEntity user, @RequestParam String city, @RequestParam String state, @RequestParam int role) {
        System.out.println(user);
        userService.addUser(user, city, state, role);
    }

    @GetMapping("/getuser/{userId}")
//    @PreAuthorize("hasAnyAuthority('Admin')")
    public UserEntity getUser(@PathVariable("userId") int userId) {
//        System.out.println(userService.getUser(userId));
        return userService.getUser(userId);
    }

    @GetMapping("/getall/email")
    public List<String> getAllEmail() {
        return userService.getAllEmail();
    }

    @GetMapping("/getall/phone")
    public List<String> getAllPhone() {
        return userService.getAllPhone();
    }

    @DeleteMapping("/deleteuser/{userId}")
//    @PreAuthorize("hasAuthority('Admin')")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }


    @GetMapping("/cart/addtocart/{userId}")
//    @PreAuthorize("hasAnyAuthority('Admin','Seller','Buyer')")
    void addToCart(@PathVariable int userId, @RequestParam int productId) {
        System.out.println("api called");
        userService.addtoCart(userId, productId);
    }


    @GetMapping("/cart/{userId}")
    public List<CartDto> getCart(@PathVariable int userId) {
//        System.out.println(userService.getCart(userId).get(0)[9]);
        return userService.getCart(userId);
    }

    @GetMapping("/cart/deletecart/{userid}")
    public void deleteCart(@PathVariable int userid, @RequestParam int productId) {
        userService.deleteCart(userid, productId);
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            AuthResponse authResponse = new AuthResponse(userService.findByEmail(authRequest.getUsername()), jwtService.generateToken(authRequest.getUsername()));

            return authResponse;
        } else {
            throw new UsernameNotFoundException("Invalid User Request");
        }
    }

    @PostMapping("/changepassword")
    public String changePassword(@RequestBody ChangePasswordDto changePasswordDto)
    {
        return userService.changePassword(changePasswordDto);

    }

}
