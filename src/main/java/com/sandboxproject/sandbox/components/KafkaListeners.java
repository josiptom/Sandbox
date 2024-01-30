package com.sandboxproject.sandbox.components;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "testTopic",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data + " 🎉");
    }
}
