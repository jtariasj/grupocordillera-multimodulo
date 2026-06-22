package com.grupocordillera.descuentos_service.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class CampanaDescuentoDTO {

    private Integer idCampana;


    private String nombre;


    private String descripcion;


    private LocalDate fechaInicio;


    private LocalDate fechaFin;


    private String tipoDescuento;


    private double valorDescuento;


    private double presupuestoMaximo;

    private String canal;
    private Boolean activo;
}
