package com.Integracion.Biblioteca.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integracion.Biblioteca.DTO.EstudianteDTO;
import com.Integracion.Biblioteca.Entities.Estudiante;
import com.Integracion.Biblioteca.Service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.getAll();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<EstudianteDTO> getEstudianteByMatricula(@PathVariable String matricula) {
        EstudianteDTO dto = estudianteService.getEstudianteByMatricula(matricula);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> createEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        return ResponseEntity.ok(estudianteService.createEstudiante(estudianteDTO));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<EstudianteDTO> updateEstudiante(@PathVariable String matricula, @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO updated = estudianteService.updateEstudiante(matricula, estudianteDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable String matricula) {
        estudianteService.deleteEstudiante(matricula);
        return ResponseEntity.noContent().build();
    }
}
