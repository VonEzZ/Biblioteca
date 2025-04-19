package com.Integracion.Biblioteca.service;

import com.Integracion.Biblioteca.dto.LibroDTO;
import com.Integracion.Biblioteca.entity.Libro;

import java.util.List;

public interface LibroService {

    LibroDTO[] getallLibros();

    LibroDTO crearLibro(LibroDTO libroDTO);

    LibroDTO findLibroById(Long id);

    LibroDTO updateLibro(LibroDTO libroDTO);

    boolean deleteLibro(Long id);




}
