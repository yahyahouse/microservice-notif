package com.phincon.microservice.notif.service;

import com.phincon.microservice.notif.model.Notification;
import reactor.core.publisher.Mono;

public interface NotifService {
    Mono<Notification> sendNotif(Notification notif);
}
