package com.example.demo.config;

import com.example.demo.servicesImpl.JwtServiceImpl;
import com.example.demo.servicesImpl.UserDetailServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;




// This is a request filter class which is used to authenticate users using the token

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private UserDetailServiceImpl userDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader= request.getHeader("Authorization");
        String token = null;

        String userName=null;

        if(authHeader!=null && authHeader.startsWith("Bearer"))
        {
            token=authHeader.substring(7);
            try {userName=jwtService.extractUserName(token);}
            catch (IllegalArgumentException e)
            {
                System.out.println("Unable to get JWT token");
            }
            catch (ExpiredJwtException e)
            {
                System.out.println("JWT Token has expired");
            }
        }
        else {}

        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
           UserDetails userDetails= userDetailService.loadUserByUsername(userName);

           if (jwtService.validateToken(token,userDetails))
           {
               UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authenticationToken);
           }

        }

        filterChain.doFilter(request,response);
    }
}
