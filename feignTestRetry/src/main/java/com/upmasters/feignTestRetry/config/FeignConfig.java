package com.upmasters.feignTestRetry.config;

import com.upmasters.feignTestRetry.feignClients.errors.DrmClientErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

}