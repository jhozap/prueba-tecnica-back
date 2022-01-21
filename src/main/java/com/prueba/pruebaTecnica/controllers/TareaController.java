package com.prueba.pruebaTecnica.controllers;

import java.util.ArrayList;

import com.prueba.pruebaTecnica.models.TareaModel;
import com.prueba.pruebaTecnica.models.UsuarioModel;
import com.prueba.pruebaTecnica.services.TareaService;

import com.prueba.pruebaTecnica.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/api/tareas")
public class TareaController {    

    @Autowired
    TareaService tareaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value="/listar")
    public ArrayList<TareaModel> consultarTareas() {
        return tareaService.consultarTareas();
    }

    @PostMapping(value="/guardar")
    public TareaModel guardarTarea(@RequestBody TareaModel usuario) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        UsuarioModel user = usuarioService.consultarUsuarioByEmail(userEmail);
        usuario.setUsuarioId(user.getId());
        return tareaService.guardarTarea(usuario);
    }

    @DeleteMapping(value="/eliminar/{id}")
    public boolean eliminarTarea(@PathVariable("id") Long id) {
        return tareaService.eliminarTarea(id);
    }

}
