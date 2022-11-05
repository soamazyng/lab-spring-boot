package com.upmasters.feignTestRetry.feignClients.errors;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DrmClientErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {

    log.info("Error Response!!!");

    if (response.status() > 0) {
      return new RetryableException(
          400,
          response.reason(),
          response.request().httpMethod(), null, response.request());
    }

    return defaultErrorDecoder.decode(s, response);

  }

}