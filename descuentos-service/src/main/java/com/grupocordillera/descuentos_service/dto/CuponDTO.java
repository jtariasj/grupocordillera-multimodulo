package com.grupocordillera.descuentos_service.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class CuponDTO {

    private Integer idCupon;


    private Integer idCampana;


    private String codigo;

    private String descripcion;


    private Integer usosMaximos;

    private Integer usosActuales;



    private LocalDate fechaExpiracion;


    private double descuentoAdicional;

    private Boolean soloPrimerUso;
    private Boolean activo;
}
