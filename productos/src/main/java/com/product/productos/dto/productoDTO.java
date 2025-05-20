package com.product.producto.productoDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class productoDTO {
    private Long idProducto;
    private String nombreProducto;
    private Double precioProducto;
    private Integer stockProducto;
    private Boolean estadoProducto;
}
