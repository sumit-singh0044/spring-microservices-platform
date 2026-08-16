package com.user.notificationservice.kafka;

import com.user.notificationservice.user.UserCreatedEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @PostConstruct
    public void init() {
        System.out.println("KafkaConsumer initialized and ready to consume messages.");
    }

    @KafkaListener(
            topics = "user",
            groupId = "user-service-group"
    )
    public void consume(UserCreatedEvent message) {

        System.out.println("================================");
        System.out.println("USER CREATED EVENT RECEIVED");
        System.out.println("ID: " + message.getId());
        System.out.println("NAME: " + message.getName());
        System.out.println("EMAIL: " + message.getEmail());
        System.out.println("================================");
    }
}
