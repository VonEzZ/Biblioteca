package com.Integracion.Biblioteca.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "secciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;
    @ManyToOne
    private Seccion seccion;

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

}
