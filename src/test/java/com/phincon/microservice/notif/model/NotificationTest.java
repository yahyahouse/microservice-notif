package com.phincon.microservice.notif.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationTest {

    @Test
    void testNotification(){
        Notification notification = new Notification();
        notification.setId("1");
        notification.setOrderId("1");
        notification.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        notification.setStatus("Completed");

        assertEquals("1", notification.getId());
        assertEquals("1", notification.getOrderId());
        assertEquals("Completed", notification.getStatus());
        assertNotNull(notification.getCreatedDate());
    }

    @Test
    void testNotificationConstructor(){
        Notification notification = new Notification("1", "1", "Completed", new Timestamp(System.currentTimeMillis()));

        assertEquals("1", notification.getId());
        assertEquals("1", notification.getOrderId());
        assertNotNull(notification.getCreatedDate());
        assertEquals("Completed", notification.getStatus());
    }
}