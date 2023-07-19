package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "demo_topic", groupId = "groupId")
    public void listen(String message) {
        System.out.println(message);
    }
}
