package com.example.demo.servicesImpl;


import com.example.demo.dto.CartDto;
import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*This class implements the methods of the User service interface*/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    StateCityRepository stateCityRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserEntity findByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    @Override
    public void addUser(UserEntity user , String city , String state,int role) {

        StateCityEntity stateCityEntity = stateCityRepository.findByName(city, state);

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(user.getAddress().getAddress());
        addressEntity.setStateCity(stateCityEntity);
        addressRepository.save(addressEntity);

        RoleEntity roleEntity = roleRepository.findById(role).get();
        Set<RoleEntity> roleEntities=new HashSet<>();
        roleEntities.add(roleEntity);
        user.setRole(roleEntities);
        user.setAddress(addressEntity);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
    }

//    @Override
//    public void addtoCart(String userid, int productid)
//    {
//        try
//        {
//            String email=jwtService.extractUserName(userid);
//            UserEntity user=userRepo.findByEmail(email).orElse(null);
//            ProductEntity product=productRepository.findById(productid).orElse(null);
//            List<ProductEntity> templist = user.getCart();
//            templist.add(product);
//            user.setCart(templist);
//            userRepo.save(user);
//
//            System.out.println("Product added to cart");
//
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//
//    }

    @Override
    public void addtoCart(int userid, int productid)
    {
        try
        {
            UserEntity user=userRepo.findById(userid).orElse(null);
            ProductEntity product=productRepository.findById(productid).orElse(null);
            List<ProductEntity> templist = user.getCart();
            templist.add(product);
            user.setCart(templist);
            userRepo.save(user);
            System.out.println("Product added to cart");
        }
        catch (Exception e)
        {
            System.out.println("error");
            throw e;
//            return e.toString();
        }

    }

    @Override
    public void deleteCart(int userid, int productid) {

        try
        {
            UserEntity user=userRepo.findById(userid).orElse(null);
            ProductEntity product=productRepository.findById(productid).orElse(null);

            List<ProductEntity> templist = user.getCart();
//            templist.removeAll(Collections.singleton(product));
            templist.remove(product);
            user.setCart(templist);
            userRepo.save(user);

        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public List<CartDto> getCart(int userid) {


        List<CartDto> cartList = new ArrayList<>();

        for (int i = 0; i < userRepo.getCart(userid).size(); i++)
        {
            ProductEntity productEntity = productRepository.findById((int) userRepo.getCart(userid).get(i)[0]).orElse(null);
            long count = (long) userRepo.getCart(userid).get(i)[2];
            CartDto cartDto = new CartDto();
            cartDto.setProductEntity(productEntity);
            cartDto.setQuantity(count);
            cartList.add(cartDto);
        }

        return cartList;

    }


    @Override
    public UserEntity getUser(int userId)
    {
        UserEntity userEntity = userRepo.findById(userId).orElse(null);
        if(userEntity==null){
            return null;
        }else{
            return userEntity;
        }
    }

    @Override
    public void deleteUser(int userId)
    {
        UserEntity userEntity = userRepo.findById(userId).orElse(null);
        int addressId = userEntity.getAddress().getId();
        userEntity.setRole(null);
        userRepo.save(userEntity);
        userRepo.deleteById(userId);
        addressRepository.deleteById(addressId);
    }

    @Override
    public List<String> getAllEmail()
    {
        return userRepo.getAllEmail();
    }

    @Override
    public List<String> getAllPhone()
    {
        return userRepo.getAllPhone();
    }

    @Override
    public String changePassword(ChangePasswordDto changePasswordDto)
    {
        UserEntity user = userRepo.findById(changePasswordDto.getId()).orElse(null);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean passmatch=encoder.matches(changePasswordDto.getOldpassword(),user.getPassword());

        if (passmatch)
        {
            user.setPassword(encoder.encode(changePasswordDto.getNewpassword()));
            userRepo.save(user);
            System.out.println("passoword changed");
            return "Password Changed";
        }
        else
        {
            System.out.println();
            return "Incorrect Old Password";
        }



    }


}
