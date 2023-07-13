package com.example.demo.servicesImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;



// This is a service class which has all the functionality of JWT authentication (Generating Token, Validating Token etc.)

@Service
public class JwtServiceImpl {

    public static final String SECRET = "189e739aebc49d3bd08f875c1a1da56c646763dd4376b70d7ad36d383752a37f";

    public String extractUserName(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token)
    {
        return extractClaim(token,Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails)
    {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    public String generateToken(String userName) {

        Map<String,Object> claims = new HashMap<>();


        return createToken(claims,userName);
    }

    private String createToken(Map<String, Object> claims, String userName)
    {
        return Jwts.builder().
                setClaims(claims).setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
//                30 min
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24*10))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
