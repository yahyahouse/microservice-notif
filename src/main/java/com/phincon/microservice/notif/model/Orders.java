package com.phincon.microservice.notif.model;

import lombok.Data;

@Data
public class Orders {
    String id;
    String productId;
    String status;
    Long price;
}
