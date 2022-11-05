package com.upmasters.feignTestRetry.feignClients.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CredenciaisDTO {

  private String login;

  private String senha;

}