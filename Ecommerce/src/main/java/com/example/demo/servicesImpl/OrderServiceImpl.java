package com.example.demo.servicesImpl;

import com.example.demo.dto.CartDto;
import com.example.demo.entities.*;
import com.example.demo.repositories.DeliveryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
/*This class implements the methods of the Order service interface*/
public class OrderServiceImpl implements OrderService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UserServiceImpl userService;




    @Override
    public String addorder(int buyerId)
    {
        List<CartDto> cartDtoList=userService.getCart(buyerId);
        System.out.println(cartDtoList);
        List<ProductEntity> products = new ArrayList<>();
        int amount=0;

        for (int i = 0; i <cartDtoList.size() ; i++)
        {
            products.add(cartDtoList.get(i).getProductEntity());

            amount+=(cartDtoList.get(i).getProductEntity().getPrice())*(cartDtoList.get(i).getQuantity());

        }
        System.out.println(amount);

        OrderEntity orderEntity = new OrderEntity();
        UserEntity userEntity = userRepository.findById(buyerId).orElse(null);
//
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setExpectedDeliveryDate(LocalDateTime.now().plusDays(4));
        deliveryEntity.setDelivered(false);

                orderEntity.setUser(userEntity);
                orderEntity.setProduct(products);
                orderEntity.setPaymentAmount(amount);
                orderEntity.setDelivery(deliveryEntity);
                orderEntity.setAddress(userEntity.getAddress().getAddress());
                orderEntity.setOrderStatus(OrderStatus.pending);
                orderEntity.setOrderDate(LocalDateTime.now());
                try
                {
                    deliveryRepository.save(deliveryEntity);
                    orderRepository.save(orderEntity);
//                    productService.decreaseCount();
                    System.out.println("order placed ");
                    return "Order Placed Successfully";
                }
                catch (Exception e)
                {
                    return e.toString();
                }


    }

    @Override
    public OrderEntity showOrder(int orderId) {

        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Integer> findLatest(int userId) {
        return orderRepository.findLatestOrder(userId);
    }

    @Override
    public List<OrderEntity> showAllOrdersByUserId(int userId)
    {
        return orderRepository.findByUser(userId);
    }

    @Override
    public String cancelOrder(int orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElse(null);
        orderEntity.setOrderStatus(OrderStatus.cancelled);

        try
        {
            orderRepository.save(orderEntity);
            return "Order Cancelled";
        }
        catch (Exception e)
        {
            return e.toString();
        }


    }


}
