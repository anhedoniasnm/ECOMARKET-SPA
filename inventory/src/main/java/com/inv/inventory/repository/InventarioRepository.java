package com.inv.inventory.repository;

import com.inv.inventory.model.inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<inventario, Long> {

}
