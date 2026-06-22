package com.grupocordillera.reportes_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "tipo_reporte", nullable = false, length = 50)
    private String tipoReporte;

    @CreationTimestamp
    @Column(name = "fecha_generacion",nullable = false)
    private LocalDateTime fechaGeneracion;

    @Column(name = "id_usuario",nullable = false)
    private int idUsuario; //El id del usuario quien creo el reporte

    @Column(name = "estado_reporte",nullable = false)
    private String estadoReporte; // Procesando, Completado, Fallido

}