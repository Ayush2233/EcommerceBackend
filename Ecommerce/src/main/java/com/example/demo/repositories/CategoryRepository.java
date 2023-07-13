package com.example.demo.repositories;

import com.example.demo.entities.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/* This interface gives access to all CRUD operations on the Category table in database*/
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

    @Query(value = "select * from category where name=?1",nativeQuery = true)
    public CategoryEntity findByName(String name);

}
