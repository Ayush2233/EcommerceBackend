package com.example.demo.servicesImpl;

import com.example.demo.entities.UserDetailsEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

// This class implements the inbuilt UserDetailsService Interface


@Component
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<UserEntity> userEntity= userRepository.findByEmail(username);
        return userEntity.map(UserDetailsEntity::new).orElseThrow(()->new UsernameNotFoundException("User not found with Email :"+username));

    }

}
