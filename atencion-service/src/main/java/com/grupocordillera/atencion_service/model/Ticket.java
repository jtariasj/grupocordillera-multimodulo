package com.grupocordillera.atencion_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    private enum Prioridad{
        ALTA, MEDIA, BAJA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 11, nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoTicket tipoTicket;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoTicket estadoTicket;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridad", nullable = false)
    private Prioridad prioridad;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
