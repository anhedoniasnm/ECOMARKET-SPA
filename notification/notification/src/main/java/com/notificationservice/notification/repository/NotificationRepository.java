package com.notificationservice.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notificationservice.notification.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {


}
