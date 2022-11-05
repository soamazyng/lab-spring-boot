package com.upmasters.workerkafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upmasters.workerkafka.domain.LibraryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class LibraryEventProducer {
  private final KafkaTemplate<String, String> kafkaTemplate;
  @Autowired
  ObjectMapper objectMapper;
  @Value("${cloudkarafka.topic}")
  private String topic;
  LibraryEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
  public void sendLibraryEvent(LibraryEvent libraryEvent) throws JsonProcessingException {

    String value = objectMapper.writeValueAsString(libraryEvent);
    this.kafkaTemplate.send(topic, value);

  }

}