package com.prueba.pruebaTecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import com.prueba.pruebaTecnica.models.UsuarioModel;

public interface IUsuarioService {
 
    public ArrayList<UsuarioModel> consultarUsuarios();

    public UsuarioModel guardarUsuario(UsuarioModel usuario);

    public Optional<UsuarioModel> consultarUsuarioById(Long id);

    public boolean eliminarUsuario(Long id);    

}
