package com.Integracion.Biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integracion.Biblioteca.Entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
