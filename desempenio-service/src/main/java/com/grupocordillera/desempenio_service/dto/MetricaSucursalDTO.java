package com.grupocordillera.desempenio_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MetricaSucursalDTO {

    private Integer idMetrica;

    private String nombre;

    private double valorActual; //Dato en el momento

    private double metaObjetivo;

    private String unidadMedida; // porcentaje o monetario (% o $)

    private LocalDateTime ultimaActualizacion; // Marca de tiempo

    private SucursalDTO sucursal;
}
