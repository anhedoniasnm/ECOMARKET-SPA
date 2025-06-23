package com.user.usuario.service;

import org.springframework.stereotype.Service;
import com.user.usuario.model.Usuario;
import com.user.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class usuarioService1 {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodoslosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(usuario.idUsuario);
    }

    @Transactional
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() != null && usuarioRepository.existsById(usuario.getIdUsuario())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<Usuario> actualizarUsuario(Long id, Usuario usuario) {
        if (!usuarioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuario.setIdUsuario(id);
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Void> eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public List<Usuario> obtenerUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombreUsuarioContainingIgnoreCase(nombre);
    }
}
