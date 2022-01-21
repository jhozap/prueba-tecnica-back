package com.prueba.pruebaTecnica.services;

import com.prueba.pruebaTecnica.Dto.LoginDto;
import com.prueba.pruebaTecnica.models.UsuarioModel;

public interface IAuthService {

    public UsuarioModel login(LoginDto auth);
    
}
