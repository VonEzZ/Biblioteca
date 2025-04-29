package com.Integracion.Biblioteca.Service;

import com.Integracion.Biblioteca.DTO.TicketDTO;
import java.util.List;

public interface ITicketService {
    List<TicketDTO> getAllTickets();

    TicketDTO getTicketById(Long id);

    TicketDTO crearTicket(TicketDTO ticketDTO);

    TicketDTO updateTicket(TicketDTO ticketDTO);

    void deleteTicket(Long id);
}
