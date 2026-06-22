package com.grupocordillera.descuentos_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

// DTO para consumir datos del retail-service (POS)
@Data
public class VentaFisicaDTO {
    private Integer id;
    private String numeroBoleta;
    private LocalDateTime fechaVenta;
    private Integer idSucursal;
    private double total;
    private String estado;
}
