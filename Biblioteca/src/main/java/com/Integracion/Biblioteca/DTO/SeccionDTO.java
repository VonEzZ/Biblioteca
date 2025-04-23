package com.Integracion.Biblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeccionDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
}