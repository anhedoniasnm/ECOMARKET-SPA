package com.peds.pedido.service;

import com.peds.pedido.dto.*;
import com.peds.pedido.model.Pedido;
import com.peds.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    private pedidoDTO toDTO(Pedido pedido) {
        pedidoDTO dto = new pedidoDTO();
        dto.setIdPedido(pedido.obtenerPedidoPorId());
        dto.setNombreCliente(pedido.getNombreCliente());
        dto.setDireccionCliente(pedido.getDireccionCliente());
        dto.setTelefonoCliente(pedido.getTelefonoCliente());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setTotalPedido(pedido.getTotalPedido());
        dto.setEstadoPedido(pedido.getEstadoPedido());
        return dto;
    }

    //@Autowired
    //CONEXION DE CLEINTE A LOS PEDIDOS

}
