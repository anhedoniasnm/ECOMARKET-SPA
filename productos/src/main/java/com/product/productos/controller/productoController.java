package main.java.com.product.productos.controller;

import com.product.productos.model.Producto;
import com.product.productos.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframkework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class productoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodosProductos() {
        return productoService.obtenerTodosProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(idProducto);
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(idProducto, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(idProducto);
    }
}
