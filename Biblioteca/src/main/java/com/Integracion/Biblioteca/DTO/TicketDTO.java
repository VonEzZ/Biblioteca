package com.Integracion.Biblioteca.DTO;

import java.time.LocalDate;

import com.Integracion.Biblioteca.Entities.Estudiante;
import com.Integracion.Biblioteca.Entities.Libro;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketDTO {

    private long id;
    private LocalDate fechaPrestasmo;
    private LocalDate fechaRegreso;
    private Estudiante matricula;
    private Libro id_libro;
}
