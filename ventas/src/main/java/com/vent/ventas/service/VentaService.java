package com.vent.ventas.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vent.ventas.model.Venta;
import com.vent.ventas.repository.VentaRepository;
import com.vent.ventas.webclient.ClienteClient;
import com.vent.ventas.webclient.EmpleadoClient;
import com.vent.ventas.webclient.ProductoClient;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {
      
    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private EmpleadoClient empleadoClient;  

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired 
    private ProductoClient productoClient;

    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    public Venta crearVenta(Venta nuevaVenta){

        Map<String, Object> cliente = clienteClient.obtenerClientePorId(nuevaVenta.getIdCliente());
        if(cliente == null) {
            throw new RuntimeException("Cliente no encontrado con ID: " + clienteClient.getIdCliente());
        }

        Map<String, Object> empleado = empleadoClient.obtenerEmpleadoPorId(nuevaVenta.getIdEmpleado());
        if(empleado == null) {
            throw new RuntimeException("Empleado no encontrado con ID: " + nuevaVenta.getIdEmpleado());
        }

        Map<String, Object> producto = productoClient.obtenerProductoPorId(nuevaVenta.getIdProducto());
        if(producto == null) {
            throw new RuntimeException("Producto no encontrado con ID: " + nuevaVenta.getIdProducto());
        }

        
    }
}
