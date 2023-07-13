package com.example.demo.controller;

import com.example.demo.entities.OrderEntity;
import com.example.demo.servicesImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This a Order Controller class which has all the url endpoints related to order related services



@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrderContoller {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/addorder")
//    @PreAuthorize("hasAnyAuthority('Admin','Buyer','Seller')")
    public String addOrder(@RequestParam int buyerId)
    {
        return orderService.addorder(buyerId);
    }
    @GetMapping("/showorder/{orderId}")
//    @PreAuthorize("hasAnyAuthority('Admin')")
    public OrderEntity showOrder(@PathVariable int orderId)
    {
        return orderService.showOrder(orderId);
    }

    @GetMapping("/user/showorder/{userId}")
//    @PreAuthorize("hasAnyAuthority('Admin')")
    public List<OrderEntity> showOrderByUser(@PathVariable int userId)
    {

        return orderService.showAllOrdersByUserId(userId);
    }

    @GetMapping("/cancelorder/{orderId}")
//    @PreAuthorize("hasAnyAuthority('Admin','Seller','Buyer')")
    public String cancelOrder(@PathVariable int orderId)
    {
        return orderService.cancelOrder(orderId);
    }

    @GetMapping("/getlatest/{userId}")
    public  List<Integer> findLatest(@PathVariable int userId)
    {
        return orderService.findLatest(userId);
    }

}
