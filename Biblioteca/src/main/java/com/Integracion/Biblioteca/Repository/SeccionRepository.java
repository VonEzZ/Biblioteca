package com.Integracion.Biblioteca.Repository;

import com.Integracion.Biblioteca.Entities.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Long> {
    boolean existsByNombre(String nombre);
}
