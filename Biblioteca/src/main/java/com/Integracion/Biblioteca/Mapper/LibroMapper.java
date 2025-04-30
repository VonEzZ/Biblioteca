package com.Integracion.Biblioteca.Mapper;

import com.Integracion.Biblioteca.DTO.LibroDTO;
import com.Integracion.Biblioteca.Entities.Libro;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LibroMapper {

    Libro toEntity(LibroDTO libroDTO);

    LibroDTO toDTO(Libro libro);
}
