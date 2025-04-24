package com.example.ProyectoBiblioteca.Mapper;

import com.example.ProyectoBiblioteca.DTO.EstudianteDTO;
import com.example.ProyectoBiblioteca.Entities.Estudiante;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EstudianteMapper {

    Estudiante toEntity(EstudianteDTO dto);

    EstudianteDTO toDTO(Estudiante entity);
}
 
