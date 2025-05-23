package com.prov.proveedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prov.proveedor.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar proveedores por nombre, etc.

}
