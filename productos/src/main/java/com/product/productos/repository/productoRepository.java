package main.java.com.producto.producto.repository;

import com.producto.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar productos por nombre
    // List<Producto> findByNombre(String nombre);

}