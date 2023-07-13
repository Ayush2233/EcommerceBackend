package com.example.demo.services;


import com.example.demo.entities.OrderEntity;

import java.util.List;

/*This is the service interface where all the methods related to Order table are defined*/
public interface OrderService {

    String addorder(int buyerId);

    OrderEntity showOrder(int orderId);

    List<Integer> findLatest(int userId);

    List<OrderEntity> showAllOrdersByUserId(int userId);

    String cancelOrder(int orderId);


}
