package com.product.productos.service;

import com.product.productos.dto.*;
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

    private productoDTO toDTO(Producto producto) {
        productoDTO dto = new productoDTO();
        dto.setIdProducto(producto.getIdProducto());
        dto.setNombreProducto(producto.getNombreProducto());
        dto.setPrecioProducto(producto.getPrecioProducto());
        dto.setStockProducto(producto.getStockProducto());
        return dto;
    }

    private Producto toEntity(productoDTO dto) {
        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        producto.setNombreProducto(dto.getNombreProducto());
        producto.setPrecioProducto(dto.getPrecioProducto());
        producto.setStockProducto(dto.getStockProducto());
        return producto;
    }

    public List<productoDTO> obtenerTodosLosProductos() {
        return productoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public productoDTO obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto != null ? toDTO(producto) : null;
    }

    public productoDTO guardarProducto(productoDTO dto) {
        Producto producto = toEntity(dto);
        Producto savedProducto = productoRepository.save(producto);
        return toDTO(savedProducto);
    }

    public productoDTO actualizarProducto(Long id, productoDTO dto) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombreProducto(dto.getNombreProducto());
            existingProducto.setPrecioProducto(dto.getPrecioProducto());
            existingProducto.setStockProducto(dto.getStockProducto());
            Producto updatedProducto = productoRepository.save(existingProducto);
            return toDTO(updatedProducto);
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