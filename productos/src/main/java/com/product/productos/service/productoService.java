package com.product.productos.service;

import com.product.productos.model.Producto;
import com.product.productos.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class productoService {

    @Autowired
    private productoRepository productoRepository;

    private Producto producto;
    public Producto crearProducto() {
        producto = new Producto();
        producto.setIdProducto(producto.getIdProducto());
        producto.setNombreProducto(producto.getNombreProducto());
        producto.setPrecioProducto(producto.getPrecioProducto());
        return producto;
    }


    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll().stream()
            .collect(Collectors.toList());
    }

    public Producto obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }

    public Producto guardarProducto() {
        Producto producto = new Producto();
        Producto savedProducto = productoRepository.save(producto);
        return savedProducto;
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombreProducto(producto.getNombreProducto());
            existingProducto.setPrecioProducto(producto.getPrecioProducto());
            Producto updatedProducto = productoRepository.save(existingProducto);
            return updatedProducto;
        }
        return null;
    }

    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}