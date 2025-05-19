package main.java.com.producto.producto.service;

import com.producto.producto.model.Producto;
import com.producto.producto.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    private ProductRepository productRepository;


    public List<Producto> obtenerTodosProductos() {
        return productRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        return productRepository.save(producto);
    } //metodo para crear y guardar un producto

    public Producto actualizarProducto(Long id, Producto producto) {
        if(productRepository.existsById(id)) {
            producto.setId(id);
            return productRepository.save(producto);
        }
        return null;
    }

    public void eliminarProducto(Long id) {
        productRepository.deleteById(id);
    }
}
