package com.product.productos.controller;

import com.product.productos.service.productoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.product.productos.dto.productoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class productoController {
    @Autowired
    private productoService productoService;

    @GetMapping
    public List<productoDTO> obtenerTodosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}")
    public productoDTO obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping
    public productoDTO guardarProducto(@RequestBody productoDTO producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public productoDTO actualizarProducto(@PathVariable Long id, @RequestBody productoDTO producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
