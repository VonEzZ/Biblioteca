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

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    // Getters y Setters:
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}
