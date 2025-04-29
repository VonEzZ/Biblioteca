package com.Integracion.Biblioteca.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private long id;
    private LocalDate fechaPrestamo; 
    private LocalDate fechaRegreso;
    private String matriculaId;
 
    private Long libroId; 
}
