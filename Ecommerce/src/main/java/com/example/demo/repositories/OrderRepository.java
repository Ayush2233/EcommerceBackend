package com.example.demo.repositories;

import com.example.demo.entities.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/* This interface gives access to all CRUD operations on the Order table in database*/
public interface OrderRepository extends CrudRepository<OrderEntity,Integer> {

    @Query(value = "select * from orders where user_id=?1",nativeQuery = true)
    public List<OrderEntity> findByUser(int usedId);

    @Query(value = "select id from orders where user_id=?1 order by id desc",nativeQuery = true)
    public List<Integer> findLatestOrder(int userId);
}
