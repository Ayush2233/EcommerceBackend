package com.example.demo.servicesImpl;

import com.example.demo.entities.CategoryEntity;
import com.example.demo.entities.ProductEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*This class implements the methods of the Product service interface*/
public class ProductServiceImpl implements ProductService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    public String addProduct(ProductEntity productEntity,int sellerId,String category)
    {
        System.out.println("into service");
        CategoryEntity categoryEntity = categoryRepository.findByName(category);
        UserEntity userEntity = userRepository.findById(sellerId).orElse(null);
        System.out.println(productEntity);

            try {
                productEntity.setUserEntity(userEntity);
                productEntity.setCategory(categoryEntity);
                System.out.println(productEntity);
                productRepository.save(productEntity);
                return "Product added Successfully";
            }
            catch (Exception e)
            {
                return e.toString();
            }
    }

    @Override
    public ProductEntity getProductbyId(int productId)
    {
        try{
            System.out.println("hi");
        return productRepository.getByID(productId);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<ProductEntity> getProductByCategory(String category)
    {

        CategoryEntity categoryEntity = categoryRepository.findByName(category);
        int categoryId = categoryEntity.getId();
        return productRepository.getProductEntityByCategory(categoryId);
    }



    @Override
    public String deleteProduct(int productId)
    {
        productRepository.deleteById(productId);
        return "Deleted Successfully";

    }

    @Override
    public List<ProductEntity> getLimitedProducts(int limit) {
        return productRepository.getLimited(limit);
    }


    @Override
    public List<ProductEntity> getAllProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @Override
    public List<ProductEntity> getProductsBySeller(int sellerId)
    {
        return productRepository.getProductEntityBySeller(sellerId);
    }

    @Override
    public String decreaseCount(int productId)
    {
        try
        {
            ProductEntity productEntity = productRepository.findById(productId).orElse(null);
            int initialCount = productEntity.getCount();
            productEntity.setCount(initialCount - 1);
            productRepository.save(productEntity);
            return "Success";
        }
        catch (Exception e)
        {
            return e.toString();
        }

    }

    @Override
    public Boolean checkStock(int productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);

        if(productEntity.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public List<Integer> searchProduct(String name) {
        return productRepository.searchProduct(name);
    }


}
