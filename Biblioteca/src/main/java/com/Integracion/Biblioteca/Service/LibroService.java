package com.Integracion.Biblioteca.Service;

import com.Integracion.Biblioteca.DTO.LibroDTO;

public interface LibroService {

    LibroDTO[] getallLibros();

    LibroDTO crearLibro(LibroDTO libroDTO);

    LibroDTO findLibroById(Long id);

    LibroDTO updateLibro(LibroDTO libroDTO);

    boolean deleteLibro(Long id);




}
