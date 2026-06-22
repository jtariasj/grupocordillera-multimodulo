package com.grupocordillera.atencion_service.repository;

import com.grupocordillera.atencion_service.model.TipoTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTicketRepository extends JpaRepository<TipoTicket, Integer> {
}
