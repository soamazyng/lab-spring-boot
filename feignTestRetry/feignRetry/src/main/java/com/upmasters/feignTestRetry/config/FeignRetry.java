package com.upmasters.feignTestRetry.config;

import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class FeignRetry implements feign.Retryer {

  private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();
  private final int maxAttempts;
  private final long backoff;
  int attemp;

  public FeignRetry(final int maxAttempts, final long backoff) {
    this.maxAttempts = maxAttempts;
    this.backoff = backoff;
    this.attemp = 1;
  }

  public FeignRetry(){
    this(5, 5000);
  }


  @Override
  public void continueOrPropagate(final RetryableException e) {

    log.info("Retrying: " + e.request().url() + "attemp: " + attemp);

    if (attemp++ >= maxAttempts){
      throw e;
    }

    try{
      TimeUnit.MILLISECONDS.sleep(backoff);
    }catch (InterruptedException ex){
      log.error(ex.getMessage());
      Thread.currentThread().interrupt();
    }

  }

  @Override
  public Retryer clone()
  {
    return new FeignRetry(maxAttempts, backoff);
  }
}