package com.grupocordillera.atencion_service.repository;

import com.grupocordillera.atencion_service.model.EstadoTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoTicketRepository extends JpaRepository<EstadoTicket, Integer> {
}
