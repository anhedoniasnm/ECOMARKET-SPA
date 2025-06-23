package com.user.usuario.controller;

import com.user.usuario.model.categoriaUsuario;
import com.user.usuario.service.categoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class categoriaUsuarioController {
    @Autowired
    private categoriaUsuarioService categoriaUsuarioService;

    @GetMapping
    public List<categoriaUsuario> obtenerTodasLasCategorias() {
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<categoriaUsuario> obtenerCategoriaPorId(@PathVariable Long id) {
        return categoriaUsuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public categoriaUsuario crearCategoria(@RequestBody categoriaUsuario categoria) {
        return categoriaUsuarioService.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<categoriaUsuario> actualizarCategoria(@PathVariable Long id, @RequestBody categoriaUsuario categoria) {
        if (!categoriaUsuarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoria.setIdCategoria(id);
        return ResponseEntity.ok(categoriaUsuarioService.save(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (!categoriaUsuarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoriaUsuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
