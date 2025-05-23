package com.vent.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vent.ventas.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    

}
