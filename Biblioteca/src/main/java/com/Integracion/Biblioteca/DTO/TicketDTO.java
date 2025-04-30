package com.Integracion.Biblioteca.DTO;

import lombok.Data;
import java.time.LocalDate;

import com.Integracion.Biblioteca.Entities.Estudiante;
import com.Integracion.Biblioteca.Entities.Libro;

@Data
public class TicketDTO {
    private Long id;
    private Estudiante estudiante;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaRegreso;
   

}

