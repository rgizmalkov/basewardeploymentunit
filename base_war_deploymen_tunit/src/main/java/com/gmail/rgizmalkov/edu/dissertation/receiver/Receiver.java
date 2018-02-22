package com.gmail.rgizmalkov.edu.dissertation.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class Receiver {
    private final static Logger logger = LoggerFactory.getLogger(Receiver.class);

    private final String name;

    public Receiver(String name) {
        this.name = name;
    }

    @KafkaListener(topics = "test_with_partitions")
    public void listen(@Payload String payload, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.OFFSET) int offset) {
            logger.info(String.format("[Receiver:%s, partition = %s, offset = %s] payload = %s", name, partition, offset, payload));
    }
}
