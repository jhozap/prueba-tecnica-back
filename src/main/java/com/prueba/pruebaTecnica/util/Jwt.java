package com.prueba.pruebaTecnica.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Jwt {
    static String SECRET = "secretKey";
    static Integer DURATION = 7200000;

    public static String getJWTToken(String email) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts.builder()
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
    }

    public static Claims getClaimsFromToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }

    public static boolean thereIsAJWTToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader("Authorization");
        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer "))
            return false;
        return true;
    }
}
