package com.upmasters.feignTestRetry.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(name = "example", url = "http://localhost:9082/")
public interface ExampleClient {

  @PostMapping("/users")
  ResponseEntity<Void> example();

  @PutMapping("/users")
  ResponseEntity<Void> example400();

}