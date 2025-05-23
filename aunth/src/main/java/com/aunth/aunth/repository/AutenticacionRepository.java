package com.aunth.aunth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aunth.aunth.model.Autenticacion;

@Repository
public interface AutenticacionRepository extends JpaRepository<Autenticacion, Long> {
    
    //METODO Q VERIFIQUE DATOS DE USUARIO
    Autenticacion findByUsername(String username);

}
