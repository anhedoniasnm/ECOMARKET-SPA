package com.product.productos.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")  
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    
    @Column(nullable = false)
    private String nombreProducto;
    
    private String descripcionProducto;

    @Column(nullable = false)
    private double precioProducto;

    private int stockProducto;
    private String categoriaProducto;

    @Column(nullable = false)
    private Boolean estadoProducto;

    private List<Producto> productos;
}