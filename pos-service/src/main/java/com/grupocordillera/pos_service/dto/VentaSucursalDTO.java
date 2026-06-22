package com.grupocordillera.pos_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VentaSucursalDTO {

    private Integer idVenta;
    private SucursalDTO sucursal;
    private String numeroBoleta;
    private LocalDateTime fechaVenta;
    private double total;

}
