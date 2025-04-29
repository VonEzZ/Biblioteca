package com.Integracion.Biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Integracion.Biblioteca.Entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}

