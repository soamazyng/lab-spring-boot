package com.upmasters.apiexample;

import com.upmasters.feignTestRetry.FeignTestRetryApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignTestRetryApplication.class, args);
  }

}