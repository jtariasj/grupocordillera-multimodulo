package com.grupocordillera.ecommerce_service.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos_online")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "numero_pedido", nullable = false, unique = true, length = 50)
    private String numeroPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteDigital cliente;


    @Column(name = "fecha_pedido", nullable = false)
    private LocalDateTime fechaPedido;


    @Column(name = "direccion_entrega", nullable = false)
    private String direccionEntrega;


    @Column(nullable = false)
    private double total;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado = EstadoPedido.PENDIENTE;

    @Column(nullable = false)
    private Boolean activo = true;

    public enum EstadoPedido { PENDIENTE, CONFIRMADO, DESPACHADO, ENTREGADO, CANCELADO }
}
