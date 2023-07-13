package com.example.demo.services;


import com.example.demo.entities.CategoryEntity;
import com.example.demo.entities.ProductEntity;

import java.util.List;

/*This is the service interface where all the methods related to Product table are defined*/
public interface ProductService
{
    String addProduct(ProductEntity productEntity,int sellerId,String category);

    ProductEntity getProductbyId(int productId);

    List<ProductEntity> getProductByCategory(String category);

    String deleteProduct(int productId);

    List<ProductEntity> getLimitedProducts(int limit);

    List<ProductEntity> getAllProducts();
    List<CategoryEntity> getAllCategories();

    List<ProductEntity> getProductsBySeller(int sellerId);

    String decreaseCount(int productId);

    Boolean checkStock(int productId);

    List<Integer> searchProduct(String name);
}
