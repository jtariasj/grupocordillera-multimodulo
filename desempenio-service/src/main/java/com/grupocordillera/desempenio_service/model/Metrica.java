package com.grupocordillera.desempenio_service.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metrica")
public class Metrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "valor_actual",nullable = false)
    private double valorActual; //Dato en el momento

    @Column(name = "meta_objetivo",nullable = false)
    private double metaObjetivo;

    @Column(name = "unidad_medida",nullable = false)
    private String unidadMedida; // porcentaje o monetario (% o $)

    @UpdateTimestamp
    @Column(name = "ultima_actualizacion",nullable = false)
    private LocalDateTime ultimaActualizacion; // Marca de tiempo
}