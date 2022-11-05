package com.upmasters.feignTestRetry.feignClients;

import com.upmasters.feignTestRetry.feignClients.Dtos.CredenciaisDTO;
import com.upmasters.feignTestRetry.feignClients.Dtos.TokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsuarioClientFallback implements UsuarioClient{
  @Override
  public ResponseEntity<TokenDTO> autenticar(final CredenciaisDTO credenciaisDTO) {

    log.info("Deu fallback");

    return null;
  }
}