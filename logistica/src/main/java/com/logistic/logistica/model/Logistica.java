package com.logistic.logistica.model;

import javax.management.Notification;

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
    private Long id;

    @Column(nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private Pedido pedido;

    @Column(nullable = false)
    private Notif notificacion;

}
