package com.upmasters.producersqs.producer;


import com.upmasters.producersqs.DTO.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
<<<<<<< Updated upstream
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

=======
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    queueMessagingTemplate.send(endpoint, payload);

=======
    send(payload, "testeMsgGroup", "msgDeduplication");

  }

  public void send(Object message, String messageGroupId, String messageDeduplicationId) throws MessagingException {
    Map<String, Object> headers = new HashMap<>();
    headers.put("message-group-id", messageGroupId);
    headers.put("message-deduplication-id", messageDeduplicationId);
    queueMessagingTemplate.convertAndSend(endpoint, message, headers);
>>>>>>> Stashed changes
  }

}