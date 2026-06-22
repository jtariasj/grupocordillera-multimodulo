package com.grupocordillera.atencion_service.model;

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
@Table(name = "estado_ticket")
public class EstadoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 11, nullable = false, unique = true)
    private Integer id;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "estadoTicket", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

}
