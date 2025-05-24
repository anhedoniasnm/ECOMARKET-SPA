package com.notif.notificacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notif.notificacion.model.Notif;

@Repository
public interface NotifRepository extends JpaRepository<Notif, Long> {

}
