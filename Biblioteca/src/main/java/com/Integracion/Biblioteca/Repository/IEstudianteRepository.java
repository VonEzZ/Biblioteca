package com.Integracion.Biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integracion.Biblioteca.Entities.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, String> {
}
