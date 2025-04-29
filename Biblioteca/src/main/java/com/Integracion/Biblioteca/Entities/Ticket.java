package com.Integracion.Biblioteca.Entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ticket")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Fecha_Prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "Fecha_Regreso", nullable = false)
    private LocalDate fechaRegreso;

    // Relacion entre las tablas
    @ManyToOne
    @JoinColumn(name = "Id", referencedColumnName = "id", nullable = false)
    private Estudiante matricula;

    
    @JoinColumn(name = "ID_Libro", referencedColumnName = "id", nullable = false)
    private Libro id_libro;
}
