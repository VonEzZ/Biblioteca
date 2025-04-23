package com.Integracion.Biblioteca.Mapper;

import com.Integracion.Biblioteca.DTO.SeccionDTO;
import com.Integracion.Biblioteca.Entity.Seccion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeccionMapper {
    SeccionMapper INSTANCE = Mappers.getMapper(SeccionMapper.class);

    SeccionDTO seccionToSeccionDTO(Seccion seccion);

    Seccion seccionDTOToSeccion(SeccionDTO seccionDTO);
}