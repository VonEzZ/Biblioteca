package com.Integracion.Biblioteca.Service.ServiceImpl;
import com.Integracion.Biblioteca.DTO.SeccionDTO;
import com.Integracion.Biblioteca.Entities.Seccion;
import com.Integracion.Biblioteca.Mapper.SeccionMapper;
import com.Integracion.Biblioteca.Repository.SeccionRepository;
import com.Integracion.Biblioteca.Service.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeccionServiceImpl implements SeccionService {

    private final SeccionRepository seccionRepository;
    private final SeccionMapper seccionMapper;

    @Autowired
    public SeccionServiceImpl(SeccionRepository seccionRepository, SeccionMapper seccionMapper) {
        this.seccionRepository = seccionRepository;
        this.seccionMapper = seccionMapper;
    }

    @Override
    public SeccionDTO crearSeccion(SeccionDTO seccionDTO) {
        Seccion seccion = seccionMapper.seccionDTOToSeccion(seccionDTO);
        Seccion seccionGuardada = seccionRepository.save(seccion);
        return seccionMapper.seccionToSeccionDTO(seccionGuardada);
    }

    @Override
    public List<SeccionDTO> getAllSecciones() {
        return seccionRepository.findAll()
                .stream()
                .map(seccionMapper::seccionToSeccionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeccionDTO getSeccionById(Long id) {
        return seccionRepository.findById(id)
                .map(seccionMapper::seccionToSeccionDTO)
                .orElse(null);
    }

    @Override
    public SeccionDTO updateSeccion(SeccionDTO seccionDTO) {
        Seccion seccion = seccionMapper.seccionDTOToSeccion(seccionDTO);
        Seccion seccionActualizada = seccionRepository.save(seccion);
        return seccionMapper.seccionToSeccionDTO(seccionActualizada);
    }

    @Override
    public void deleteSeccion(Long id) {
        seccionRepository.deleteById(id);
    }

    @Override
    public boolean existeSeccion(Long id) {
        return seccionRepository.existsById(id);
    }
}
