package com.user.usuario.service;

import com.user.usuario.model.categoriaUsuario;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.user.usuario.repository.categoriaUsuarioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class categoriaUsuarioService {
    @Autowired
    private categoriaUsuarioRepository repository;

    public List<categoriaUsuario> findAll() {
        return repository.findAll();
    }

    public Optional<categoriaUsuario> findById(Long id) {
        return repository.findById(id);
    }

    public categoriaUsuario save(categoriaUsuario categoria) {
        return repository.save(categoria);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
