package com.upmasters.feignTestRetry.services;

import com.upmasters.feignTestRetry.feignClients.Dtos.CredenciaisDTO;
import com.upmasters.feignTestRetry.feignClients.ExampleClient;
import com.upmasters.feignTestRetry.feignClients.UsuarioClient;
import feign.FeignException;
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

  @Autowired
  private ExampleClient exampleClient;

  public void getToken(){

    CredenciaisDTO credenciaisDTO = CredenciaisDTO.builder()
        .login("admin")
        .senha("123")
        .build();

    try {
      usuarioFeignClient.autenticar(credenciaisDTO).getBody();
    } catch (FeignException ex){
      log.info(ex.getMessage());
    }

    log.info("teste");

  }

  public void getExample(){

    try {
      exampleClient.example400().getBody();
    } catch (FeignException ex){
      log.error(ex.getMessage());
    }

    log.info("finalizou");

  }

}