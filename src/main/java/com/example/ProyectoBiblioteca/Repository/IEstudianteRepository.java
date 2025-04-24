package com.example.ProyectoBiblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ProyectoBiblioteca.Entities.Estudiante;



@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, String> {
}


