package com.phincon.microservice.notif.service;

import com.phincon.microservice.notif.model.Notification;
import com.phincon.microservice.notif.repository.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NotifServiceImplTest {
    @Mock
    NotificationRepository notificationRepository;
    @InjectMocks
    NotifServiceImpl notifService;

    @Test
    void sendNotifTest() {
        Notification notif = new Notification("1", "1", "Completed", new Timestamp(System.currentTimeMillis()));
        Mockito.when(notificationRepository.save(notif)).thenReturn(Mono.just(notif));
        Mono<Notification> resultMono = notifService.sendNotif(notif);
        Notification result = resultMono.block();
        assertEquals(notif, result);
    }


}