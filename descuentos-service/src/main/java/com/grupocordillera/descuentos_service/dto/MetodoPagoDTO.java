package com.grupocordillera.descuentos_service.dto;

import lombok.Data;

@Data
public class MetodoPagoDTO {
    private Integer id;
    private String nombre;
    private String tipo;
    private String descripcion;
    private Boolean activo;
}
