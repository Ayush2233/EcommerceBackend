package com.example.demo.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//This class implements the inbuilt UserDetails interface to make UserDetails objects to be used in authentication

public class UserDetailsEntity implements UserDetails {


    private String email;
    private String password;
    private Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();



    public UserDetailsEntity(UserEntity userEntity) {
        email =userEntity.getEmail();
        password=userEntity.getPassword();
        userEntity.getRole().forEach(roleEntity -> {
            roles.add(new SimpleGrantedAuthority(roleEntity.getRole()));

        });


//        System.out.println(roles);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
