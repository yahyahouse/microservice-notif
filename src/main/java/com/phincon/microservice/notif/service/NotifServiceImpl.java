package com.phincon.microservice.notif.service;

import com.phincon.microservice.notif.model.Notification;
import com.phincon.microservice.notif.model.Orders;
import com.phincon.microservice.notif.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.UUID;

@Service
@Slf4j
public class NotifServiceImpl implements NotifService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotifServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @JmsListener(destination = "queue.notif")
    public void receiveNotif(Message<Orders> orders) {
        log.info("Notification sent Orchestration: " + orders.getPayload().getStatus());
        sendNotif(new Notification(UUID.randomUUID().toString(),
                orders.getPayload().getId(),
                orders.getPayload().getStatus(),
                new Timestamp(System.currentTimeMillis()))).subscribe();
    }

    @Override
    public Mono<Notification> sendNotif(Notification notif) {
        Mono<Notification> notificationMono = notificationRepository.save(notif);
        log.info("Notification sent API: " + notif);
        return notificationMono;
    }
}
