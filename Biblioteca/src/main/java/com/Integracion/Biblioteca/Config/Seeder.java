package com.Integracion.Biblioteca.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Integracion.Biblioteca.Entities.*;
import com.Integracion.Biblioteca.Repository.*;

import java.time.LocalDate;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    private IEstudianteRepository estudianteRepo;

    @Autowired
    private LibroRepository libroRepo;

    @Autowired
    private SeccionRepository seccionRepo;

    @Autowired
    private TicketRepository ticketRepo;

    @Override
    public void run(String... args) throws Exception {
        // Crear sección
        Seccion s1 = new Seccion();
        s1.setNombre("Filosofía");
        s1.setUbicacion("Segundo piso");

        if (seccionRepo.findByNombre(s1.getNombre()) == null) {
            seccionRepo.save(s1);
        }

        // Crear libro
        Libro l1 = new Libro();
        l1.setTitulo("La República");
        l1.setAutor("Platón");
        l1.setSeccion(s1);

        if (libroRepo.findByTitulo(l1.getTitulo()) == null) {
            libroRepo.save(l1);
        }

        // Crear estudiante
        Estudiante e1 = new Estudiante();
        e1.setNombre("Juan");
        e1.setCarrera("Filosofía");
        e1.setMatricula("A123");
      

        if (estudianteRepo.findByMatricula(e1.getMatricula()) == null) {
            estudianteRepo.save(e1);
        }

        
        Ticket t1 = new Ticket();
        t1.setEstudiante(e1);
        t1.setLibro(l1);
        t1.setFechaPrestamo(LocalDate.now());

        ticketRepo.save(t1);
    }
}
