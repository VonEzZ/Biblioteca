package com.Integracion.Biblioteca.Controller;

import com.Integracion.Biblioteca.DTO.SeccionDTO;
import com.Integracion.Biblioteca.Service.SeccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secciones")
public class SeccionController {

    private final SeccionService seccionService;

    public SeccionController(SeccionService seccionService) {
        this.seccionService = seccionService;
    }

    @PostMapping
    public ResponseEntity<SeccionDTO> createSeccion(@RequestBody SeccionDTO seccionDTO) {
        SeccionDTO nuevaSeccion = seccionService.crearSeccion(seccionDTO);
        return new ResponseEntity<>(nuevaSeccion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SeccionDTO>> getAllSecciones() {
        List<SeccionDTO> secciones = seccionService.getAllSecciones();
        return new ResponseEntity<>(secciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeccionDTO> getSeccionById(@PathVariable Long id) {
        SeccionDTO seccionDTO = seccionService.getSeccionById(id);
        if (seccionDTO != null) {
            return new ResponseEntity<>(seccionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeccionDTO> updateSeccion(@PathVariable Long id, @RequestBody SeccionDTO seccionDTO) {
        if (!seccionService.existeSeccion(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        seccionDTO.setId(id);
        SeccionDTO updatedSeccion = seccionService.updateSeccion(seccionDTO);
        return new ResponseEntity<>(updatedSeccion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeccion(@PathVariable Long id) {
        if (!seccionService.existeSeccion(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        seccionService.deleteSeccion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}