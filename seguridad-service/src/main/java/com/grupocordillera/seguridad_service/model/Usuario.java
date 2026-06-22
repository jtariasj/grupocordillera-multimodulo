package com.grupocordillera.seguridad_service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @UpdateTimestamp
    @Column(name = "ultimo_acceso", nullable = false)
    private LocalDate ultimoAcceso;
    //A pesar de su nombre la funcion que tiene
    // es de la ultima modificacion de alguno de sus datos

    @ManyToOne
    @JoinColumn(name = "id_rol",referencedColumnName = "id_rol")
    private Roles rol;
}
