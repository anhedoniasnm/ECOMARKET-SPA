package com.peds.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peds.pedido.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository PedidoRepository;

    //@Autowired
    //CONEXION DE CLEINTE A LOS PEDIDOS

}
