package com.Integracion.Biblioteca.Controller;

import com.Integracion.Biblioteca.DTO.LibroDTO;
import com.Integracion.Biblioteca.Entities.Libro;
import com.Integracion.Biblioteca.Repository.LibroRepository;
import com.Integracion.Biblioteca.Service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class LibroController {

    private final LibroRepository libroRepository;
    private final LibroService libroService;

    public LibroController(LibroRepository libroRepository, LibroService libroService) {
        this.libroRepository = libroRepository;
        this.libroService = libroService;
    }

    @PostMapping("/libro")
    public LibroDTO createLibro(@RequestBody LibroDTO libroDTO) {
        return libroService.crearLibro(libroDTO);
    }

    @GetMapping("/libros")
    public List<LibroDTO> getAllLibros() {
        for (Libro libro : libroRepository.findAll()) {
            System.out.println(libro);
        }
        return List.of(libroService.getallLibros());
    }

    @GetMapping("/libro/{libro}")
    public LibroDTO getLibroById(@PathVariable Long libro) {
       LibroDTO libroDTO = null;
       for(LibroDTO libroDTO1: libroService.getallLibros()){
            if(libroDTO1.getId() == libro){
            libroDTO = libroDTO1;
            break;
            }
       }
       return new ResponseEntity<LibroDTO>(libroDTO, HttpStatus.OK).getBody();
    }

    @DeleteMapping("/libro/{libro}")
    public ResponseEntity<LibroDTO> deleteLibro(@PathVariable Long libro) {
        LibroDTO libroDTO = null;
        for(LibroDTO libroDTO1: libroService.getallLibros()){
            if(libroDTO1.getId() == libro){
                libroDTO = libroDTO1;
                break;
            }
        }
        if(libroDTO != null){
            libroService.deleteLibro(libro);
        }
        return new ResponseEntity<>(libroDTO, HttpStatus.OK);
    }

    @PutMapping("/libro/{libro}")
    public LibroDTO updateLibro(@RequestBody LibroDTO libroDTO, @PathVariable Long libro) {
        LibroDTO libroDTO1 = null;
        for(LibroDTO libroDTO2: libroService.getallLibros()){
            if(libroDTO2.getId() == libro){
                libroDTO1 = libroDTO2;
                break;
            }
        }
        if(libroDTO1 != null){
            libroDTO.setId(libroDTO1.getId());
            libroDTO1.setId(libroDTO.getId());
            libroDTO1.setTitulo(libroDTO.getTitulo());
            libroDTO1.setAutor(libroDTO.getAutor());
            libroDTO1.setEditorial(libroDTO.getEditorial());
            libroDTO1.setFecha(libroDTO.getFecha());
            libroService.updateLibro(libroDTO1);
        }
        return libroDTO1;
    }


}
