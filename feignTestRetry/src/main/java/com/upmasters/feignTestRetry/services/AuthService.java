package com.upmasters.feignTestRetry.services;

import com.upmasters.feignTestRetry.feignClients.Dtos.CredenciaisDTO;
import com.upmasters.feignTestRetry.feignClients.Dtos.TokenDTO;
import com.upmasters.feignTestRetry.feignClients.UsuarioClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthService {

  @Autowired
  private UsuarioClient usuarioFeignClient;

  public void getToken(){

    CredenciaisDTO credenciaisDTO = CredenciaisDTO.builder()
        .login("admin")
        .senha("123")
        .build();

    TokenDTO token = usuarioFeignClient.autenticar(credenciaisDTO).getBody();

    log.info(token.toString());

  }

}