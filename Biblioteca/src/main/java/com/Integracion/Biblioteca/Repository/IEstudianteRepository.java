<<<<<<< HEAD
package com.Integracion.Biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integracion.Biblioteca.Entities.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, String> {
}
=======
package com.Integracion.Biblioteca.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integracion.Biblioteca.Entities.Estudiante;
import com.Integracion.Biblioteca.Entities.Ticket;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, String> {
    Estudiante findByMatricula(String matricula);

    Optional<Ticket> findById(Long estudiante);
}
>>>>>>> origin/sergio
