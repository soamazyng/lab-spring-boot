package com.upmasters.feignTestRetry.controllers;

import com.upmasters.feignTestRetry.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class TokenController {

  @Autowired
  private AuthService service;

  @PostMapping()
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Void> getPayment(){

    service.getToken();

    return ResponseEntity.ok().build();

  }

}