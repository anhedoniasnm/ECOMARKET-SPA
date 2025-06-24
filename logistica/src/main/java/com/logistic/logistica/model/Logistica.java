package com.logistic.logistica.model;

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
@Table(name = "logistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;

    @Column(nullable = false)
    private Long idChofer;

    @Column(nullable = false)
    private Long idPedido;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private String direccionEnvio;

    @Column(nullable = false)
    private String estadoEnvio;
    
}
