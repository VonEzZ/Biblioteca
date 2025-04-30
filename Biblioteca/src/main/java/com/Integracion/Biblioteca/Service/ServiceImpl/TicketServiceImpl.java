package com.Integracion.Biblioteca.Service.ServiceImpl;

import com.Integracion.Biblioteca.DTO.TicketDTO;
import com.Integracion.Biblioteca.Entities.Ticket;
import com.Integracion.Biblioteca.Repository.TicketRepository;
import com.Integracion.Biblioteca.Service.ITicketService;
import com.Integracion.Biblioteca.Repository.LibroRepository;
import com.Integracion.Biblioteca.Repository.IEstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements ITicketService {

    private final TicketRepository ticketRepository;
    private final LibroRepository libroRepository;
    private final IEstudianteRepository estudianteRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, LibroRepository libroRepository,
            IEstudianteRepository estudianteRepository) {
        this.ticketRepository = ticketRepository;
        this.libroRepository = libroRepository;
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        return ticketRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public TicketDTO crearTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setFechaPrestamo(ticketDTO.getFechaPrestamo());
        ticket.setFechaRegreso(ticketDTO.getFechaRegreso());
        ticket.setEstudiante(ticketDTO.getEstudiante());
        ticket.setLibro(ticketDTO.getLibro());
        return convertToDTO(ticketRepository.save(ticket));
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.findById(ticketDTO.getId()).orElse(null);
        if (ticket == null)
            return null;
        ticket.setFechaPrestamo(ticketDTO.getFechaPrestamo());
        ticket.setFechaRegreso(ticketDTO.getFechaRegreso());
        ticket.setEstudiante(ticketDTO.getEstudiante());
        ticket.setLibro(ticketDTO.getLibro());
        return convertToDTO(ticketRepository.save(ticket));
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    private TicketDTO convertToDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setFechaPrestamo(ticket.getFechaPrestamo());
        dto.setFechaRegreso(ticket.getFechaRegreso());
        dto.setEstudiante(ticket.getEstudiante());
        dto.setLibro(ticket.getLibro());
        return dto;
    }
}