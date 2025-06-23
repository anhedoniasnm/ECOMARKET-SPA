package com.product.productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categoria_producto")
public class categoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaProducto;

    @Column(nullable = false)
    private String nombreCategoria;

    @Column(nullable = false)
    private String descripcionCategoria;
}
