package com.Integracion.Biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Integracion.Biblioteca.DTO.EstudianteDTO;
import com.Integracion.Biblioteca.Entities.Estudiante;
import com.Integracion.Biblioteca.Repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    private final IEstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(IEstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteDTO getEstudianteByMatricula(String matricula) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(matricula);
        return estudiante.map(this::toDTO).orElse(null);
    }

    @Override
    public EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = toEntity(estudianteDTO);
        estudiante = estudianteRepository.save(estudiante);
        return toDTO(estudiante);
    }

    @Override
    public EstudianteDTO updateEstudiante(String matricula, EstudianteDTO estudianteDTO) {
        Optional<Estudiante> optional = estudianteRepository.findById(matricula);
        if (optional.isPresent()) {
            Estudiante estudiante = optional.get();
            estudiante.setNombre(estudianteDTO.getNombre());
            estudiante.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
            estudiante.setApellidoMaterno(estudianteDTO.getApellidoMaterno());
            estudiante.setCarrera(estudianteDTO.getCarrera());
            estudiante = estudianteRepository.save(estudiante);
            return toDTO(estudiante);
        }
        return null;
    }

    @Override
    public void deleteEstudiante(String matricula) {
        estudianteRepository.deleteById(matricula);
    }

    private EstudianteDTO toDTO(Estudiante e) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setMatricula(e.getMatricula());
        dto.setNombre(e.getNombre());
        dto.setApellidoPaterno(e.getApellidoPaterno());
        dto.setApellidoMaterno(e.getApellidoMaterno());
        dto.setCarrera(e.getCarrera());
        return dto;
    }

    private Estudiante toEntity(EstudianteDTO dto) {
        Estudiante e = new Estudiante();
        e.setMatricula(dto.getMatricula());
        e.setNombre(dto.getNombre());
        e.setApellidoPaterno(dto.getApellidoPaterno());
        e.setApellidoMaterno(dto.getApellidoMaterno());
        e.setCarrera(dto.getCarrera());
        return e;
    }
}