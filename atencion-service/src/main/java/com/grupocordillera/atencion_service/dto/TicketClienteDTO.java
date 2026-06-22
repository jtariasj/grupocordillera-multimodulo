package com.grupocordillera.atencion_service.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketClienteDTO {

    private Integer idTicket;

    private String tipoTicket;

    private String estadoTicket;

    private ClienteDTO cliente;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaCierre;


}
