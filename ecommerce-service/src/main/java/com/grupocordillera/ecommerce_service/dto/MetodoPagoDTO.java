package com.grupocordillera.ecommerce_service.dto;

import lombok.Data;

@Data
public class MetodoPagoDTO {


    private String nombre;

    private TipoPago tipo;

    public enum TipoPago { EFECTIVO, TARJETA_DEBITO, TARJETA_CREDITO, TRANSFERENCIA, OTRO }
}
