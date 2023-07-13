package com.example.demo.controller;

import com.example.demo.entities.ProductEntity;
import com.example.demo.servicesImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// This a Product Controller class which has all the url endpoints related to product related services


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController
{
    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/addproduct")
//    @PreAuthorize("hasAnyAuthority('Seller')")
    public String addProduct(@RequestBody ProductEntity productEntity, @RequestParam int sellerId,@RequestParam String category)
    {
        System.out.println("into contrller");
        System.out.println(productEntity);
        return productService.addProduct(productEntity,sellerId,category);
    }

    @GetMapping("/limit/{limit}")
//    @PreAuthorize("hasAnyAuthority('Buyer','Seller','Admin')")
    public List<ProductEntity> getLimitedProducts(@PathVariable int limit)
    {
        return productService.getLimitedProducts(limit);
    }



    @GetMapping("/getbyid/{productId}")
//    @PreAuthorize("hasAnyAuthority('Buyer','Seller','Admin')")
    public ProductEntity getProductById(@PathVariable int productId)
    {
        try {
            System.out.println("hello");
            return productService.getProductbyId(productId);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("/category/{categoryName}")
    public List<ProductEntity> getProductByCategory(@PathVariable String categoryName)
    {
        return productService.getProductByCategory(categoryName);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    @PreAuthorize("hasAnyAuthority('Seller','Admin')")
    public String deleteProduct(@PathVariable int productId)
    {
        return productService.deleteProduct(productId);
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('Seller','Admin')")
    public List<ProductEntity> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/seller/{sellerId}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public List<ProductEntity> getProductBySeller(@PathVariable int sellerId)
    {
        return productService.getProductsBySeller(sellerId);
    }

    @GetMapping("/search/{name}")
    public  List<Integer> searchProduct(@PathVariable String name)
    {
        return productService.searchProduct(name);
    }


}
