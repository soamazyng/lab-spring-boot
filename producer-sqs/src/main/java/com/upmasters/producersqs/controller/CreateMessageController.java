package com.upmasters.producersqs.controller;

import com.upmasters.producersqs.DTO.MessageDto;
import com.upmasters.producersqs.producer.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateMessageController {

  @Autowired
  MessageSender messageSender;

  @PostMapping("/v1/messages")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Void> postMessage(@RequestBody MessageDto messageDto){

    messageSender.send(messageDto);

    return null;
  }

}