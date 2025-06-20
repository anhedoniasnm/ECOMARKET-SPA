package com.user.usuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(nullable = false, unique = true)
    private String nombreUsuario;
    @Column(nullable = false, unique = true)
    private String emailUsuario;
    @Column(nullable = false)
    private String passwordUsuario;
    @Column(nullable = false)
    private String telefonoUsuario;
    @Column(nullable = false)
    private String direccionUsuario;

    @ManyToOne
    @JoinColumn(name = "rol_id",nullable = false)
    @JsonIgnoreProperties("usuarios")
    private Rol rol;
}
