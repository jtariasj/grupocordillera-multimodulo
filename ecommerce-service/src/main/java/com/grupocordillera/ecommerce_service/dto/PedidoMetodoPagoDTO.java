package com.grupocordillera.ecommerce_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoMetodoPagoDTO {

    private Integer idPedido;

    private Integer id_cliente;

    private String numeroPedido;

    private LocalDateTime fechaPedido;

    private MetodoPagoDTO metodoPago;

    private double total;

}
