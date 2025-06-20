package com.user.usuario.model;

import jakarta persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "categoria_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoriaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaUsuario;

    @Column(nullable = false)
    private String nombreCategoriaUsuario;

    @Column(nullable = false)
    private String descripcionCategoriaUsuario;
}
