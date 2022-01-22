package com.prueba.pruebaTecnica.repositories;

import com.prueba.pruebaTecnica.models.TareaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface TareaRepository extends CrudRepository<TareaModel, Long>, JpaRepository<TareaModel, Long> {

    @Query(value = "SELECT * from tareas "
            + "WHERE usuario_id = :usuarioId ", nativeQuery = true)
    ArrayList<TareaModel> consultarTareas (@Param("usuarioId") Long usuarioId);
    
}
