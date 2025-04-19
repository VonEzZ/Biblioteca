package com.Integracion.Biblioteca.mapper;

import com.Integracion.Biblioteca.dto.LibroDTO;
import com.Integracion.Biblioteca.entity.Libro;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LibroMapper {

    Libro toEntity(LibroDTO libroDTO);

    LibroDTO toDTO(Libro libro);
}
