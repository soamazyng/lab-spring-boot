package com.upmasters.workerkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LibraryEventConsumer {

  @KafkaListener(topics = "${cloudkarafka.topic}")
  public void processMessage(String message,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                             @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                             @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

    log.info(message);

  }
}