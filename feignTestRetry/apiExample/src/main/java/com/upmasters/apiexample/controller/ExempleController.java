package com.upmasters.apiexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example")
public class ExempleController {

  @PostMapping()
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Void> getExample(){

    return ResponseEntity.ok().build();

  }

}