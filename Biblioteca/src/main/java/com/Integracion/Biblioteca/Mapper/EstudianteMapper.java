package com.Integracion.Biblioteca.Mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


import com.Integracion.Biblioteca.DTO.EstudianteDTO;
import com.Integracion.Biblioteca.Entities.Estudiante;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EstudianteMapper {

    Estudiante toEntity(EstudianteDTO estduianteDto);

    EstudianteDTO toDTO(Estudiante estudiante);
}

