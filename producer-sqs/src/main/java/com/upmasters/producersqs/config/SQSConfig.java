package com.upmasters.producersqs.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

  @Value("${cloud.aws.credentials.access-key}")
  private String accessKey;
  @Value("${cloud.aws.credentials.secret-key}")
  private String secretKey;

  @Value("${cloud.aws.region.static}")
  private String region;

  @Bean
  public QueueMessagingTemplate queueMessagingTemplate (AmazonSQSAsync amazonSQSAsync){

    return new QueueMessagingTemplate(amazonSQSAsync());

  }

  private AmazonSQSAsync amazonSQSAsync() {

    BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

    return AmazonSQSAsyncClientBuilder
        .standard()
        .withRegion(region)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();

  }

}