package com.product.productos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class productoDTO {
    private Long idProducto;
    private String nombreProducto;
    private Double precioProducto;
}
