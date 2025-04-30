package com.Integracion.Biblioteca.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class LibroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String editorial;
    private LocalDate fecha;
    private Long idSeccion;
}
