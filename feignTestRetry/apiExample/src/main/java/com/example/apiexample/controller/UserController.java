package com.example.apiexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")
class UserController {
  @GetMapping()
  public ResponseEntity<Void> getUser() {
    return ResponseEntity.ok().build();
  }

  @PostMapping()
  public ResponseEntity<Void> postUser() {
    return ResponseEntity.internalServerError().build();
  }

  @PutMapping()
  public ResponseEntity<Void> putUser() {
    return ResponseEntity.notFound().build();
  }

  @PatchMapping()
  public ResponseEntity<Void> notFoundUser() {
    return ResponseEntity.notFound().build();
  }

}