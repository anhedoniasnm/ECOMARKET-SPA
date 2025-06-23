package com.user.usuario.repository;
import org.springframework.stereotype.Repository;   
import com.user.usuario.model.CategoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface categoriaRepository 
    extends JpaRepository<CategoriaUsuario, Long> {
}
