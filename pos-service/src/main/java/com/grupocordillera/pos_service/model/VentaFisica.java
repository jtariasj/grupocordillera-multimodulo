package com.grupocordillera.pos_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas_fisicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "numero_boleta", nullable = false, unique = true, length = 50)
    private String numeroBoleta;


    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(nullable = false)
    private double total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVenta estado = EstadoVenta.PENDIENTE;

    @Column(nullable = false)
    private Boolean activo = true;

    @JsonIgnore
    @OneToMany(mappedBy = "ventaFisica", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles = new ArrayList<>();

    public enum EstadoVenta { PENDIENTE, COMPLETADA, ANULADA }
}
