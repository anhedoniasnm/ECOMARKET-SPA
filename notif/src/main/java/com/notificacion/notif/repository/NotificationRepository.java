package com.notificacion.notif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
