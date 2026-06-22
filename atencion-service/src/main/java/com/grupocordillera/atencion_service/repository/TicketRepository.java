package com.grupocordillera.atencion_service.repository;

import com.grupocordillera.atencion_service.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
