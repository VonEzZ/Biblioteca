package com.Integracion.Biblioteca.service.impl;

import com.Integracion.Biblioteca.dto.LibroDTO;
import com.Integracion.Biblioteca.entity.Libro;
import com.Integracion.Biblioteca.mapper.LibroMapper;
import com.Integracion.Biblioteca.repository.LibroRepository;
import com.Integracion.Biblioteca.service.LibroService;

import java.util.List;
import java.util.Optional;

public class LibroServiceImpl implements LibroService {

    private final LibroMapper libroMapper;
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroMapper libroMapper, LibroRepository libroRepository) {
        this.libroMapper = libroMapper;
        this.libroRepository = libroRepository;
    }



    @Override
    public LibroDTO[] getallLibros() {
        List<Libro> libros = libroRepository.findAll();
        LibroDTO[] libroDTOs = new LibroDTO[libros.size()];
        for (int i = 0; i < libros.size(); i++) {
            libroDTOs[i] = libroMapper.toDTO(libros.get(i));
        }
        return libroDTOs;
    }

    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO) {

        Libro libro = libroMapper.toEntity(libroDTO);

        Libro savedLibro = libroRepository.save(libro);

        LibroDTO savedLibroDTO = libroMapper.toDTO(savedLibro);
        return savedLibroDTO;
    }

    @Override
    public LibroDTO findLibroById(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        LibroDTO libroDTO = libroMapper.toDTO(libro.get());
        return libroDTO;
    }

    @Override
    public LibroDTO updateLibro(LibroDTO libroDTO) {
        Optional<Libro> libro = libroRepository.findById(libroDTO.getId());
        libro.get().setTitulo(libroDTO.getTitulo());
        libro.get().setAutor(libroDTO.getAutor());
        libro.get().setEditorial(libroDTO.getEditorial());
        libro.get().setFecha(libroDTO.getFecha());
        libro.get().setIdSeccion(libroDTO.getIdSeccion());
        libroRepository.save(libro.get());
        return libroDTO;
    }

    @Override
    public boolean deleteLibro(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        libroRepository.delete(libro.get());
        return libro.isPresent();
    }
}
