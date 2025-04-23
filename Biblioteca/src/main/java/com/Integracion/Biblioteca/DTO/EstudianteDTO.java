package com.Integracion.Biblioteca.DTO;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class EstudianteDTO {
    
    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera;
}
