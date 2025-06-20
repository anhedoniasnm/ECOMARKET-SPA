package com.peds.pedido.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor  
@AllArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private String fechaPedido;

    @Column(nullable = false)
    private String estadoPedido;

    @Column(nullable = false)
    private double totalPedido;


}