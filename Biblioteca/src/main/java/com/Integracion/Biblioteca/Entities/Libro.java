package com.Integracion.Biblioteca.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Table(name = "libro")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 30)
    private String titulo;

    @Column(nullable = false, unique = false, length = 30)
    private String autor;

    @Column(nullable = false, unique = false, length = 20)
    private String editorial;

    @Column(nullable = false, unique = false)
    private LocalDate fecha;

    @Column(nullable = false, unique = false)
    private Long IdSeccion;



}
