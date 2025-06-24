package com.pagos.pago.model;
import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Enitity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @Column(nullable = false)
    private Long total;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private Long idPedido;

}
