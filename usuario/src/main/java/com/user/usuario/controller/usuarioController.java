package com.user.usuario.controller;

import com.user.usuario.model.Usuario;
import com.user.usuario.model.CategoriaUsuario;
import com.user.usuario.repository.UsuarioRepository;
import com.user.usuario.repository.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class usuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private categoriaRepository categoriaRepository;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerTodoslosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    @GetMapping("/usuarios/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
    
    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setCategoria(usuario.getCategoria());
        return usuarioRepository.save(usuarioExistente);
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        usuarioRepository.delete(usuarioExistente);
    }

    @GetMapping("/usuarios/nombre/{nombre}")
    public List<Usuario> obtenerUsuariosPorNombre(@PathVariable String nombre) {
        return usuarioRepository.findByNombreUsuarioContainingIgnoreCase(nombre);
    }
}
