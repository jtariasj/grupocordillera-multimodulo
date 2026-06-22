package com.grupocordillera.finanzas_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_contables")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoContable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimiento tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrigenMovimiento origen;

    @Column(nullable = false)
    private double monto;

    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;

    @Column(nullable = false)
    private Boolean activo = true;

    public enum TipoMovimiento   { INGRESO, EGRESO }
    public enum OrigenMovimiento { VENTA_FISICA, VENTA_ONLINE, DEVOLUCION, GASTO, OTRO }
}
