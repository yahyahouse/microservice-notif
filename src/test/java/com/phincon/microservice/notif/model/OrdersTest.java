package com.phincon.microservice.notif.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdersTest {

    @Test
    void ordersTest(){
        Orders orders = new Orders();
        orders.setId("1");
        orders.setProductId("1");
        orders.setStatus("Completed");
        orders.setPrice(1000L);

        assertEquals("1", orders.getId());
        assertEquals("1", orders.getProductId());
        assertEquals("Completed", orders.getStatus());
        assertEquals(1000L, orders.getPrice());
    }
}