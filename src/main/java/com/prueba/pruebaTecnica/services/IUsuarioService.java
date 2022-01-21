package com.prueba.pruebaTecnica.services;

import java.util.ArrayList;

import com.prueba.pruebaTecnica.models.UsuarioModel;

public interface IUsuarioService {
 
    public ArrayList<UsuarioModel> consultarUsuarios();

    public UsuarioModel guardarUsuario(UsuarioModel usuario);

    public boolean eliminarUsuario(Long id);    

}
