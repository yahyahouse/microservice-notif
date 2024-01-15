package com.phincon.microservice.notif.repository;

import com.phincon.microservice.notif.model.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends R2dbcRepository<Notification, String> {
}
