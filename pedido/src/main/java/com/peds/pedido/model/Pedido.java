package com.peds.pedido.model;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "pedido")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(nullable = false)
    private String fechaPedido;

    @Column(nullable = false)
    private String estadoPedido;

    @Column(nullable = false)
    private double totalPedido;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private String direccionCliente;

    @Column(nullable = false)
    private String telefonoCliente;

    @ManyToMany
    @JoinTable(
        name = "producto_pedido",
        joinColumns = @JoinColumn(name = "idPedido"),
        inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
}