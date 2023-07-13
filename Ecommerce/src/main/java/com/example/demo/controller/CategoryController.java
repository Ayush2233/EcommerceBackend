package com.example.demo.controller;

import com.example.demo.entities.CategoryEntity;
import com.example.demo.servicesImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoryController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/all")
    public List<CategoryEntity> getAllCategories()
    {
        return productService.getAllCategories();
    }

}
