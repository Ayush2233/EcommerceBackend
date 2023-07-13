package com.example.demo.repositories;

import com.example.demo.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

/* This interface gives access to all CRUD operations on the Address table in database*/
public interface AddressRepository extends CrudRepository<AddressEntity,Integer> {
}
