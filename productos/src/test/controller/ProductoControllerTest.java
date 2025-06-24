package productos.src.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException; 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllProductos() throws Exception {
        Producto producto1 = new Producto(1L, "Producto1", 100.0);
        Producto producto2 = new Producto(2L, "Producto2", 200.0);
        when(productoService.findAllProductos()).thenReturn(Arrays.asList(producto1, producto2));

        mockMvc.perform(get("/productos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].nombre").value("Producto1"))
            .andExpect(jsonPath("$[1].id").value(2L))
            .andExpect(jsonPath("$[1].nombre").value("Producto2"));
    }

    @Test
    void testGetProductoById() throws Exception {   
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoService.findProductoById(1L)).thenReturn(Optional.of(producto));

        mockMvc.perform(get("/productos/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.nombre").value("Producto1"));
    }

    @Test
    void testAddProducto() throws Exception {
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoService.addProducto(any(Producto.class))).thenReturn(producto);

        mockMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.nombre").value("Producto1"));
    }

    @Test
    void testUpdateProducto() throws Exception {
        Producto producto = new Producto(1L, "Producto1", 100.0);
        when(productoService.updateProducto(eq(1L), any(Producto.class))).thenReturn(producto);

        mockMvc.perform(put("/productos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.nombre").value("Producto1"));
    }

    @Test
    void testDeleteProducto() throws Exception {    
        doNothing().when(productoService).deleteProducto(1L);

        mockMvc.perform(delete("/productos/1"))
            .andExpect(status().isNoContent());
    }

}
