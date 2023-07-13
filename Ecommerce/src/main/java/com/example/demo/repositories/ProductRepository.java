package com.example.demo.repositories;

import com.example.demo.entities.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* This interface gives access to all CRUD operations on the Product table in database*/
@Repository

public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {
    @Query(value = "select * from product where category_id=?1",nativeQuery = true)
    public List<ProductEntity> getProductEntityByCategory(int categoryId);

    @Query(value = "select * from product where seller_id=?1",nativeQuery = true)
    public List<ProductEntity> getProductEntityBySeller(int sellerId);

    @Query(value = "{call Search_Query(?1)}",nativeQuery = true)
    public  List<Integer> searchProduct(String name);
    @Query(value = "select * from product LIMIT ?1",nativeQuery = true)
    public  List<ProductEntity> getLimited(int limit);

    @Query(value = "select * from product where p_id=?1",nativeQuery = true)
    public ProductEntity getByID(int id);

}
