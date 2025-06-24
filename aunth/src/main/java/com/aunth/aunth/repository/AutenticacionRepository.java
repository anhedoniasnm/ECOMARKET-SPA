package com.aunth.aunth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aunth.aunth.model.Autenticacion;

@Repository
public interface AutenticacionRepository extends JpaRepository<Autenticacion, Long> {
    Autenticacion findByCorreo(String correo);
    Autenticacion findByCorreoAndContrasenha(String correo, String contrasenha);
    Autenticacion findByUsername(String username);

}
