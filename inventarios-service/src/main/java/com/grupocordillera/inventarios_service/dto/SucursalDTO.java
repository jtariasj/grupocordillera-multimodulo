package com.grupocordillera.inventarios_service.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SucursalDTO {

    private Integer id;

    private String nombre;

    private String direccion;
}
