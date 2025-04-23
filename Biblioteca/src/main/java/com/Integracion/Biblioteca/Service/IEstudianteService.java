package com.Integracion.Biblioteca.Service;

import java.util.List;

import com.Integracion.Biblioteca.DTO.EstudianteDTO;
import com.Integracion.Biblioteca.Entities.Estudiante;

public interface IEstudianteService {
    List<Estudiante> getAll();
    EstudianteDTO getEstudianteByMatricula(String matricula);
    EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO updateEstudiante(String matricula, EstudianteDTO estudianteDTO);
    void deleteEstudiante(String matricula);
}