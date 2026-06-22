package com.grupocordillera.inventarios_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 11, nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Column(name = "sku", length = 12, nullable = false)
    private String sku;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "precio", precision = 7, nullable = false)
    private int precio;

    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;
}
