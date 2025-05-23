package com.logistic.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistic.logistica.model.Logistica;

@Repository
public interface LogisticaRepository extends JpaRepository<Logistica, Long> {

}
