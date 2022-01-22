package com.prueba.pruebaTecnica.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.prueba.pruebaTecnica.Dto.UsuarioDto;
import com.prueba.pruebaTecnica.models.UsuarioModel;
import com.prueba.pruebaTecnica.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path="/listar")
    public ArrayList<UsuarioModel> consultarUsuarios() {
        return usuarioService.consultarUsuarios();
    }

    @GetMapping(path="/listar/{id}")
    public Optional<UsuarioModel> consultarUsuarios(@PathVariable("id") Long id) {
        return usuarioService.consultarUsuarioById(id);
    }

    @PostMapping(path="/guardar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping(path="/eliminar/{id}")
    public boolean eliminarUsuario(@PathVariable("id") Long id) {
        return usuarioService.eliminarUsuario(id);
    }

}
