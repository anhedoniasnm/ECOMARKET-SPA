package com.vent.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vent.ventas.model.Venta;
import com.vent.ventas.service.VentaService;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerTodasLasVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(Long id) {
        return ventaService.obtenerVentaPorId(id);
    }   

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody Venta nuevaVenta) {
        try{
            return ResponseEntity.ok(ventaService.crearVenta(nuevaVenta));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(Long id) {
        try {
            ventaService.eliminarVenta(id);
            return ResponseEntity.ok("Venta eliminada con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
