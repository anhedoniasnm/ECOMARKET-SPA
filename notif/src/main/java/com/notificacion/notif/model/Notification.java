package com.notificacion.notif.model;
import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "notification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private Long idPedido;

    @Column(nullable = false)
    private Long idPago;

    @Column(nullable = false)
    private Long idEnvio;

    @Column(nullable = false)
    private String message; 



}
