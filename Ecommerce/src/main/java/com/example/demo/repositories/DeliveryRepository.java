package com.example.demo.repositories;

import com.example.demo.entities.DeliveryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* This interface gives access to all CRUD operations on the Delivery table in database*/
@Repository
public interface DeliveryRepository extends CrudRepository<DeliveryEntity,Integer> {
}
