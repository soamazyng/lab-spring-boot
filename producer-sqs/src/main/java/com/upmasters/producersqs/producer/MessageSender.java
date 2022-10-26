package com.upmasters.producersqs.producer;


import com.upmasters.producersqs.DTO.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageSender {

  @Autowired
  private QueueMessagingTemplate queueMessagingTemplate;

  @Value("${cloud.aws.end-point.uri}")
  private String endpoint;

  public void send(MessageDto messageDto) {

    Message<String> payload = MessageBuilder.withPayload(messageDto.getMessage())
        .setHeader("sender", "api jay").build();

    queueMessagingTemplate.send(endpoint, payload);

  }

}