package com.prueba.pruebaTecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import com.prueba.pruebaTecnica.models.UsuarioModel;
import com.prueba.pruebaTecnica.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> consultarUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> consultarUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel consultarUsuarioByEmail(String email) {
        return usuarioRepository.consultarUsuarioByEmail(email);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    
}
