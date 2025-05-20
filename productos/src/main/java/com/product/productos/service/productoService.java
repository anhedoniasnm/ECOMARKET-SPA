package main.java.com.product.productos.service;

import com.product.productos.dto.productoDTO;
import com.product.productos.model.Producto;
import com.product.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class productoService {

    @Autowired
    private ProductoRepository productRepository;

    private productoDTO toDTO(Producto producto) {
        productoDTO dto = new productoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        return dto;
    }

    private Producto toEntity(productoDTO dto) {
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return producto;
    }

    public List<productoDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public productoDTO getProductById(Long id) {
        Producto producto = productRepository.findById(id).orElse(null);
        return producto != null ? toDTO(producto) : null;
    }

    public productoDTO createProduct(productoDTO dto) {
        Producto producto = toEntity(dto);
        Producto savedProducto = productRepository.save(producto);
        return toDTO(Productoguardado);
    }

    public productoDTO updateProduct(Long id, productoDTO dto) {
        Producto existingProducto = productRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombre(dto.getNombre());
            existingProducto.setPrecio(dto.getPrecio());
            existingProducto.setStock(dto.getStock());
            Producto updatedProducto = productRepository.save(existingProducto);
            return toDTO(updatedProducto);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}