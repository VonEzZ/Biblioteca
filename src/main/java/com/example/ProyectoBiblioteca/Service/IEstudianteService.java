package com.example.ProyectoBiblioteca.Service;


import java.util.List;
import com.example.ProyectoBiblioteca.DTO.EstudianteDTO;
import com.example.ProyectoBiblioteca.Entities.Estudiante;


public interface IEstudianteService {
    List<Estudiante> getAll();
    EstudianteDTO getEstudianteByMatricula(String matricula);
    EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO updateEstudiante(String matricula, EstudianteDTO estudianteDTO);
    void deleteEstudiante(String matricula);
}
    
    

