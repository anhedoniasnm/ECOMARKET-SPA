package com.peds.pedido.service;

import com.peds.pedido.model.Pedido;
import com.peds.pedido.repository.PedidoRepository;
import com.peds.pedido.webclient.ProductoClient;
import com.peds.pedido.webclient.UsuarioClient;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private ProductoClient productoClient;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }
    
    public Pedido guardarPedido(Pedido pedido) {
        
        Map<String, Object> usuario = usuarioClient.getUsuarioById(pedido.getUsuarioId());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + pedido.getUsuarioId());
        }

        Map<String, Object> producto = productoClient.getProductoById(pedido.getIdPedido());
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado con ID: " + pedido.getIdPedido());
        }

        if(pedido.getNombreProducto() == null || pedido.getNombreProducto().isEmpty()) {
            throw new RuntimeException("El nombre del producto no puede estar vacío");
        }

        return pedidoRepository.save(pedido);

    }

    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
        pedidoRepository.delete(pedido);
    }

 


}
