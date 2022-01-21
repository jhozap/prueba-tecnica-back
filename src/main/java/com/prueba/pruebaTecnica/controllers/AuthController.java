package com.prueba.pruebaTecnica.controllers;

import com.prueba.pruebaTecnica.Dto.LoginDto;
import com.prueba.pruebaTecnica.models.UsuarioModel;
import com.prueba.pruebaTecnica.services.AuthService;
import com.prueba.pruebaTecnica.util.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired(required=true)
    private AuthService authService;
       

    @PostMapping(value="/login")
    public String login(@RequestBody LoginDto auth) {
        
        UsuarioModel usr = authService.login(auth);
        if(usr == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        String token = Jwt.getJWTToken(usr.getEmail());
        return "Bearer "+token;        
    }
    

}
