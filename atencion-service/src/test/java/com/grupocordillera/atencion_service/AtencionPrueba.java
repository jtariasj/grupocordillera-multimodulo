package com.grupocordillera.atencion_service;

import com.grupocordillera.atencion_service.model.EstadoTicket;
import com.grupocordillera.atencion_service.model.Ticket;
import com.grupocordillera.atencion_service.model.TipoTicket;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AtencionPrueba {
    private TipoTicket tipoTicket;
    private EstadoTicket estadoTicket;
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        tipoTicket = new TipoTicket(
                null,
                "Soporte",
                true,
                new ArrayList<>()
        );

        estadoTicket = new EstadoTicket(
                null,
                "Abierto",
                "Ticket recién creado",
                true,
                new ArrayList<>()
        );

        ticket = new Ticket(
                null,
                tipoTicket,
                estadoTicket,
                null,
                LocalDateTime.of(2025, Month.JANUARY, 10, 9, 0),
                LocalDateTime.of(2025, Month.JANUARY, 12, 17, 0),
                true
        );
    }

    @Test
    @DisplayName("AT-01 - Verificar que un tipo de ticket pueda crearse correctamente")
    public void crearTipoTicket() {
        assertNotNull(tipoTicket.getNombre());
        assertFalse(tipoTicket.getNombre().isBlank());
        assertNotNull(tipoTicket.getTickets());
        assertTrue(tipoTicket.getTickets().isEmpty());
    }

    @Test
    @DisplayName("AT-02 - Verificar que un estado de ticket pueda crearse correctamente")
    public void crearEstadoTicket() {
        assertNotNull(estadoTicket.getNombre());
        assertFalse(estadoTicket.getNombre().isBlank());
        assertNotNull(estadoTicket.getDescripcion());
        assertFalse(estadoTicket.getDescripcion().isBlank());
        assertNotNull(estadoTicket.getTickets());
        assertTrue(estadoTicket.getTickets().isEmpty());
    }

    @Test
    @DisplayName("AT-03 - Verificar que un ticket pueda crearse correctamente")
    public void crearTicket() {
        assertNotNull(ticket.getTipoTicket());
        assertNotNull(ticket.getEstadoTicket());

    }

    @Test
    @DisplayName("AT-04 - Verificar que fechaCierre no sea anterior a fechaCreacion")
    public void fechasTicketCoherentes() {
        assertTrue(ticket.getFechaCierre().isAfter(ticket.getFechaCreacion()) ||
                ticket.getFechaCierre().isEqual(ticket.getFechaCreacion()));
    }

    @Test
    @DisplayName("AT-05 - Verificar que un ticket pueda asociarse a un tipo de ticket")
    public void agregarTicketATipoTicket() {
        tipoTicket.getTickets().add(ticket);

        assertEquals(1, tipoTicket.getTickets().size());
        assertTrue(tipoTicket.getTickets().contains(ticket));
    }
}
