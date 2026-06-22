package com.grupocordillera.inventarios_service.model;

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
@Table(name = "categoria_producto")
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 11, nullable = false, unique = true)
    private Integer id;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "categoriaProducto", cascade = CascadeType.ALL) //nombre del atributo ubicado en Producto
    private List<Producto> productos = new ArrayList<>();
}
