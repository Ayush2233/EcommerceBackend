package com.example.demo.repositories;

import com.example.demo.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/* This interface gives access to all CRUD operations on the Role table in database*/
public interface RoleRepository extends CrudRepository<RoleEntity, Integer>
{

}
