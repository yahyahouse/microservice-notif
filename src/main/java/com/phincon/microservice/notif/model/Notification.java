package com.phincon.microservice.notif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Getter
    @Setter
    @Id
    String id;
    String orderId;
    String status;
    Timestamp createdDate;

}
