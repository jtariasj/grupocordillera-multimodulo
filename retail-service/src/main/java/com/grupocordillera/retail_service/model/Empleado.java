package com.grupocordillera.retail_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 11, nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @Column(name = "run", length = 8, nullable = false)
    private String run;

    @Column(name = "dv", length = 1, nullable = false)
    private String dv;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 20, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 20, nullable = false)
    private String apellidoMaterno;

    @Column(name = "correo", length = 50, nullable = false)
    private String correo;

    @Column(name = "telefono", length = 12, nullable = false)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_contrato", nullable = false)
    private LocalDate fechaContrato;

    @Column(name = "rol", length = 20, nullable = false)
    private String rol;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
