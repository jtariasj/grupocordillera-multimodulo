package com.grupocordillera.descuentos_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reglas_descuento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReglaDescuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regla")
    private Integer idRegla;

    @ManyToOne
    @JoinColumn(name = "id_campana", nullable = false)
    private CampanaDescuento campana;

    @Column(name = "nombre_regla", nullable = false, length = 150)
    private String nombreRegla;

    @Column(length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Condicion condicion;

    @Column(name = "valor_condicion", nullable = false, length = 100)
    private String valorCondicion;

    @Column(nullable = false)
    private Integer prioridad = 1;

    @Column(nullable = false)
    private Boolean acumulable = false;

    @Column(nullable = false)
    private Boolean activo = true;

    public enum Condicion {
        MONTO_MINIMO, CATEGORIA_PRODUCTO, CLIENTE_FRECUENTE, PRIMERA_COMPRA, CUPON
    }
}
