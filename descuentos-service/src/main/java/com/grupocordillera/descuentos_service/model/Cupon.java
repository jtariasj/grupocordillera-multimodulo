package com.grupocordillera.descuentos_service.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cupones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cupon")
    private Integer idCupon;

    @ManyToOne
    @JoinColumn(name = "id_campana", nullable = false)
    private CampanaDescuento campana;

    @Column(nullable = false, unique = true, length = 50)
    private String codigo;

    private String descripcion;

    @Column(name = "usos_maximos", nullable = false)
    private Integer usosMaximos = 1;

    @Column(name = "usos_actuales", nullable = false)
    private Integer usosActuales = 0;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate fechaExpiracion;

    @Column(name = "descuento_adicional", nullable = false)
    private double descuentoAdicional = 0.0;

    @Column(name = "solo_primer_uso", nullable = false)
    private Boolean soloPrimerUso = false;

    @Column(nullable = false)
    private Boolean activo = true;
}
