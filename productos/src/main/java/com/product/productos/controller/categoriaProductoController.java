package com.product.productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.product.productos.service.categoriaProductoService;
import com.product.productos.model.categoriaProducto;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/categorias")
public class categoriaProductoController {

    @Autowired
    private categoriaProductoService categoriaProductoService;

    @GetMapping
    public List<categoriaProducto> obtenerTodasLasCategorias() {
        return categoriaProductoService.obtenerTodasLasCategorias();
    }
    @GetMapping("/{id}")
    public categoriaProducto getCategoriaPorId(@PathVariable Long id) {
        return categoriaProductoService.obtenerCategoriaPorId(id);
    }
    
}
