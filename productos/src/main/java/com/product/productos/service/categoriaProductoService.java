package com.product.productos.service;

import org.springframework.stereotype.Service;
import com.product.productos.model.categoriaProducto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class categoriaProductoService {
    @Autowired
    private com.product.productos.repository.categoriaProductoRepository categoriaProductoRepository;

    public List<categoriaProducto> obtenerTodasLasCategorias() {
        return categoriaProductoRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    public categoriaProducto obtenerCategoriaPorId(Long id) {
        return categoriaProductoRepository.findById(id).orElse(null);
    }

    public categoriaProducto guardarCategoria(categoriaProducto categoria) {
        return categoriaProductoRepository.save(categoria);
    }

    public categoriaProducto actualizarCategoria(Long id, categoriaProducto categoria) {
        if (categoriaProductoRepository.existsById(id)) {
            categoria.setIdCategoria(id);
            return categoriaProductoRepository.save(categoria);
        }
        return null;
    }

    public boolean eliminarCategoria(Long id) {
        if (categoriaProductoRepository.existsById(id)) {
            categoriaProductoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
