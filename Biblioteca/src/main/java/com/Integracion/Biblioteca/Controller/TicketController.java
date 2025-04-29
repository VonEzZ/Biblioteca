package com.Integracion.Biblioteca.Controller;

import com.Integracion.Biblioteca.DTO.TicketDTO;
import com.Integracion.Biblioteca.Service.ITicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TicketController {

    private final ITicketService ticketService;

    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.crearTicket(ticketDTO);
    }

    @GetMapping("/tickets")
    public List<List<TicketDTO>> getAllTickets() {
        return List.of(ticketService.getAllTickets());
    }

    @GetMapping("/ticket/{id}")
    public TicketDTO getTicketById(@PathVariable Long id) {
        for (TicketDTO dto : ticketService.getAllTickets()) {
            if (dto.getId() == id) {
                return dto;
            }
        }
        return null;
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<TicketDTO> deleteTicket(@PathVariable Long id) {
        TicketDTO target = null;
        for (TicketDTO dto : ticketService.getAllTickets()) {
            if (dto.getId() == id) {
                target = dto;
                break;
            }
        }
        if (target != null) {
            ticketService.deleteTicket(id);
        }
        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @PutMapping("/ticket/{id}")
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long id) {
        TicketDTO existing = null;
        for (TicketDTO dto : ticketService.getAllTickets()) {
            if (dto.getId() == id) {
                existing = dto;
                break;
            }
        }
        if (existing != null) {
            ticketDTO.setId(existing.getId());
            ticketService.updateTicket(ticketDTO);
        }
        return ticketDTO;
    }
}
