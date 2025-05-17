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
    private Long id;

    //Aqui tiene que ir un arreglo de los productos que el cliente solicitó
    //@Column(nullable = false)
    //private List<Producto> productos;

    @Column(nullable = false)
    private Long clienteId; // ID del cliente que hizo el pedido
}
