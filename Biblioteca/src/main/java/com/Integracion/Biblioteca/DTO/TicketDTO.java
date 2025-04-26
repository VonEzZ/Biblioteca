package com.Integracion.Biblioteca.DTO;

import java.time.LocalDate;

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
