package com.upmasters.feignTestRetry.feignClients.errors;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {

    log.info("Error Response 1234!!!");

    if (response.status() == 404) {
      return defaultErrorDecoder.decode(s, response);
    }

    return new RetryableException(
        response.status(),
        response.reason(),
        response.request().httpMethod(),
        null,
        response.request());

  }
}