package com.upmasters.feignTestRetry.feignClients.Dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

  private String login;
  private String token;

}