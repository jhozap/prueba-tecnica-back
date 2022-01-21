package com.prueba.pruebaTecnica.services;

import java.util.ArrayList;

import com.prueba.pruebaTecnica.models.TareaModel;
import com.prueba.pruebaTecnica.repositories.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService implements ITareaService{

    @Autowired
    TareaRepository tareaRepository;

    public ArrayList<TareaModel> consultarTareas() {
        return (ArrayList<TareaModel>) tareaRepository.findAll();
    }

    public TareaModel guardarTarea(TareaModel tarea) {
        return tareaRepository.save(tarea);
    }

    public boolean eliminarTarea(Long id) {
        try {
            tareaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
