package com.Integracion.Biblioteca.Mapper;


import com.Integracion.Biblioteca.DTO.TicketDTO;
import com.Integracion.Biblioteca.Entities.Ticket;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TicketMapper {

    Ticket toEntity(TicketDTO ticketDTO);

    TicketDTO toDTO(Ticket ticket);
}
