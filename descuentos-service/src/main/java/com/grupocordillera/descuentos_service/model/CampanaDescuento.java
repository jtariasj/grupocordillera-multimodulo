package com.grupocordillera.descuentos_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campanas_descuento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampanaDescuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campana")
    private Integer idCampana;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_descuento", nullable = false)
    private TipoDescuento tipoDescuento;

    @Column(name = "valor_descuento", nullable = false)
    private double valorDescuento;

    @Column(name = "presupuesto_maximo", nullable = false)
    private double presupuestoMaximo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Canal canal = Canal.AMBOS;

    @Column(nullable = false)
    private Boolean activo = true;

    @JsonIgnore
    @OneToMany(mappedBy = "campana", cascade = CascadeType.ALL)
    private List<ReglaDescuento> reglas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "campana", cascade = CascadeType.ALL)
    private List<Cupon> cupones = new ArrayList<>();

    public enum TipoDescuento { PORCENTAJE, MONTO_FIJO }
    public enum Canal { FISICO, ONLINE, AMBOS }
}
