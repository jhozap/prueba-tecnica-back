package com.prueba.pruebaTecnica.repositories;

import com.prueba.pruebaTecnica.models.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>, JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT * from usuarios "
            + "WHERE email = :email ", nativeQuery = true)
    UsuarioModel consultarUsuarioByEmail (@Param("email") String email);

}
