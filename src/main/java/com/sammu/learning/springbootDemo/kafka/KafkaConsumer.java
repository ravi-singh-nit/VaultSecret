package com.sammu.learning.springbootDemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(
            topics = "test-topic",
            groupId = "demo-group"
    )
    public void consume(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ) {
        System.out.println(
                "Consumed message: " + message +
                        " | key=" + key +
                        " | partition=" + partition
        );
    }
}
