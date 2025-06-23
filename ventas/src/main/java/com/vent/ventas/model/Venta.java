package com.vent.ventas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // COLUMNA DE List PRODUCTO 
    @Column(nullable = false)
    private List<Producto> producto;

    // COLUMNA DE CLIENTE
    @Column(nullable = false)
    private Cliente cliente;

    // COLUMNA DE EMPLEADO
    @Column(nullable = false)
    private Empleado empleado;
}
