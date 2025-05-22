package com.peds.pedido.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class pedidoDTO {
    private Long idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String fechaPedido;
    private Double totalPedido;
    private Boolean estadoPedido;
}
