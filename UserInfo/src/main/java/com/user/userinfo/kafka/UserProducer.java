package com.user.userinfo.kafka;

import com.user.userinfo.dto.UserCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserCreatedEvent event) {
        kafkaTemplate.send("user", event).whenComplete((result, throwable) -> {
            if (throwable != null) {
                // Handle the error
                System.err.println("Failed to send message: " + throwable.getMessage());
            } else {
                // Message sent successfully
                System.out.println("Message sent successfully to topic: " + result.getRecordMetadata());
            }
        });
    }
}
