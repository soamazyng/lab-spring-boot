package com.upmasters.workerkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.upmasters.workerkafka.domain.LibraryEvent;
import com.upmasters.workerkafka.producer.LibraryEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryEventsController {
  @Autowired
  LibraryEventProducer libraryEventProducer;
  @PostMapping("/v1/libraryevent")
  public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {

    // produce kafka
    libraryEventProducer.sendLibraryEvent(libraryEvent);
    return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
  }
}