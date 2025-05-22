package com.peds.pedido.controller;

import com.peds.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.peds.pedido.dto.pedidoDTO;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class pedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<pedidoDTO> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public PedidoDTO obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PostMapping
    public PedidoDTO guardarPedido(@RequestBody PedidoDTO pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @PutMapping("/{id}")
    public PedidoDTO actualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedido) {
        return pedidoService.actualizarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }
}
