package com.prueba.pruebaTecnica.Dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private Long id;    
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    
}
