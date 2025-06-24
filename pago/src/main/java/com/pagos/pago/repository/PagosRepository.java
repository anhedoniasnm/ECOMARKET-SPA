package com.pagos.pago.repository;
import com.pagos.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepository extends JpaRepository<Pago, Long> {


}
