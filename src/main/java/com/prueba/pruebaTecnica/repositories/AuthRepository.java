package com.prueba.pruebaTecnica.repositories;

import com.prueba.pruebaTecnica.models.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<UsuarioModel, Long>{
    
    @Query(value = "SELECT * from usuarios "
			+ "WHERE email = :email "
			+ "and password = :password", nativeQuery = true)
	UsuarioModel login (@Param("email") String email, @Param("password") String password);


}
