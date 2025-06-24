package com.aunth.aunth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aunth.aunth.model.Autenticacion;
import com.aunth.aunth.repository.AutenticacionRepository;
import com.aunth.aunth.webclient.UsuarioClient;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutenticacionService {

    @Autowired
    private AutenticacionRepository autenticacionRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public AutenticacionService(AutenticacionRepository autenticacionRepository, UsuarioClient usuarioClient) {
        this.autenticacionRepository = autenticacionRepository;
        this.usuarioClient = usuarioClient;
    }

    public Autenticacion findByCorreo(String correo) {
        return autenticacionRepository.findByCorreo(correo);
    }

    public Autenticacion findByCorreoAndContrasenha(String correo, String contrasenha) {
        return autenticacionRepository.findByCorreoAndContrasenha(correo, contrasenha);
    }

    public Autenticacion findByUsername(String username) {
        return autenticacionRepository.findByUsername(username);
    }

}
