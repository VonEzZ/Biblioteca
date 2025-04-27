package com.Integracion.Biblioteca.Repository;

import com.Integracion.Biblioteca.Entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
