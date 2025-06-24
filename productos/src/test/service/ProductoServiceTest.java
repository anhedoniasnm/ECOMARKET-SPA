import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.hibernate.annotations.TimeZoneStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import productos.src.main.model.Producto;
import productos.src.main.repository.ProductoRepository;    
import productos.src.main.service.ProductoService;
import productos.src.main.service.CategoriaService;
import productos.src.main.model.Categoria;

@ExtendsWith(MockitoExtension.class)
public class ProductoServiceTest {

    @InjectMocks
    private ProductoService productoService;

    @Mock
    private ProductoRepository productoRepository;

    @Test 
    void testFindAllProductos() {
        Producto producto1 = new Producto(1L, "Producto1", 100.0);
        Producto producto2 = new Producto(2L, "Producto2", 200.0);
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoService.findAllProductos();

        assertNotNull(productos);
        assertEquals(2, productos.size());
        assertEquals("Producto1", productos.get(0).getNombre());
        assertEquals("Producto2", productos.get(1).getNombre());
    }

    @Test
    void testFindProductoById() {
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> foundProducto = productoService.findProductoById(1L);

        assertTrue(foundProducto.isPresent());
        assertEquals("Producto1", foundProducto.get().getNombre());
    }

    @Test
    void testAddProduct(){
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto savedProducto = productoService.addProduct(producto);

        assertNotNull(savedProducto);
        assertEquals("Producto1", savedProducto.getNombre());
    }

    @Test
    void testUpdateProduct() {
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto updatedProducto = productoService.updateProduct(1L, producto);

        assertNotNull(updatedProducto);
        assertEquals("Producto1", updatedProducto.getNombre());
    }

    @Test
    void testDeleteProduct() {
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        productoService.deleteProduct(1L);

        verify(productoRepository).delete(producto);
    }


}
