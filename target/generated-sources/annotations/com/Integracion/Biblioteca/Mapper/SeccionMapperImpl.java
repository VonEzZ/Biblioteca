package com.Integracion.Biblioteca.Mapper;

import com.Integracion.Biblioteca.DTO.SeccionDTO;
import com.Integracion.Biblioteca.Entity.Seccion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T15:09:22-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class SeccionMapperImpl implements SeccionMapper {

    @Override
    public SeccionDTO seccionToSeccionDTO(Seccion seccion) {
        if ( seccion == null ) {
            return null;
        }

        SeccionDTO seccionDTO = new SeccionDTO();

        seccionDTO.setId( seccion.getId() );
        seccionDTO.setNombre( seccion.getNombre() );
        seccionDTO.setDescripcion( seccion.getDescripcion() );
        seccionDTO.setUbicacion( seccion.getUbicacion() );

        return seccionDTO;
    }

    @Override
    public Seccion seccionDTOToSeccion(SeccionDTO seccionDTO) {
        if ( seccionDTO == null ) {
            return null;
        }

        Seccion seccion = new Seccion();

        seccion.setId( seccionDTO.getId() );
        seccion.setNombre( seccionDTO.getNombre() );
        seccion.setDescripcion( seccionDTO.getDescripcion() );
        seccion.setUbicacion( seccionDTO.getUbicacion() );

        return seccion;
    }
}
