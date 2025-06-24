package com.aunth.aunth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aunth.aunth.model.Autenticacion;
import com.aunth.aunth.services.AutenticacionService;

@RestController
@RequestMapping("/api/v1/autenticacion")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    @PostMapping 
    public ResponseEntity<String> authenticate() {
        Autenticacion autenticacion = new Autenticacion();
        String correo = autenticacion.getCorreo();
        String contrasenha = autenticacion.getContrasenha();
        Autenticacion existingAutenticacion = autenticacionService.findByCorreoAndContrasenha(correo, contrasenha);
        if (existingAutenticacion == null) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
        return ResponseEntity.ok("Autenticación exitosa"); 
    }



}
