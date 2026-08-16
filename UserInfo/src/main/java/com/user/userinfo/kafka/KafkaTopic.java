package com.user.userinfo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic userTopic() {
//        return new NewTopic("user-topic", 1, (short) 1);

        return TopicBuilder.name("user")
                .partitions(1)
                .replicas(1)
                .build();
    }
}


