package com.upmasters.producersqs.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageReceiver{

    @SqsListener(value = "http://localhost:4566/000000000000/sample-queue.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message){
      log.info("Message received {}", message);
    }
}