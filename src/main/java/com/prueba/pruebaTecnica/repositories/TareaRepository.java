package com.prueba.pruebaTecnica.repositories;

import com.prueba.pruebaTecnica.models.TareaModel;

import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<TareaModel, Long>{
    
}
