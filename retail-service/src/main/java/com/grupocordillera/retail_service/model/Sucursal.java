package com.grupocordillera.retail_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 11, nullable = false, unique = true)
    private Integer id;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 30, nullable = false)
    private String direccion;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Empleado> empleados =  new ArrayList<>();
}
