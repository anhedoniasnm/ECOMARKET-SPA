package main.java.com.product.productos.repository;

import com.product.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepository extends JpaRepository<Producto, Long> {
}