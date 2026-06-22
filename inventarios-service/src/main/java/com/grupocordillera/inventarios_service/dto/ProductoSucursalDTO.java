package com.grupocordillera.inventarios_service.dto;

import lombok.Data;

@Data
public class ProductoSucursalDTO {

    private Integer idProducto;
    private int cantidadActual;
    private int cantidadMinima;
    private int cantidadMaxima;

    private SucursalDTO sucursal;

}
