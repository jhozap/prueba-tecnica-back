package com.prueba.pruebaTecnica.services;

import com.prueba.pruebaTecnica.Dto.LoginDto;
import com.prueba.pruebaTecnica.models.UsuarioModel;
import com.prueba.pruebaTecnica.repositories.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UsuarioModel login(LoginDto auth) {
        return authRepository.login(auth.email, auth.password);
    }
    
}
