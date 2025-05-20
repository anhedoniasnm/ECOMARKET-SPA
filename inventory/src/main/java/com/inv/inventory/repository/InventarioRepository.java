package com.inv.inventory.repository;

import com.inv.inventory.model.inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<inventario, Long> {

}
