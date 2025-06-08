package com.peds.pedido.dto;
import java.util.List;
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
    private List<Long> productos;// Lista de IDs de productos asociados al pedido
}
