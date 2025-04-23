package com.Integracion.Biblioteca.Service;

import com.Integracion.Biblioteca.DTO.SeccionDTO;
import java.util.List;

public interface SeccionService {
    SeccionDTO crearSeccion(SeccionDTO seccionDTO);
    List<SeccionDTO> getAllSecciones();
    SeccionDTO getSeccionById(Long id);
    SeccionDTO updateSeccion(SeccionDTO seccionDTO);
    void deleteSeccion(Long id);
    boolean existeSeccion(Long id);
}