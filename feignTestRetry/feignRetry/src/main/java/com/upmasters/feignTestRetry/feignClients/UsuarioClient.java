package com.upmasters.feignTestRetry.feignClients;

import com.upmasters.feignTestRetry.feignClients.Dtos.CredenciaisDTO;
import com.upmasters.feignTestRetry.feignClients.Dtos.TokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "usuario-client", url = "http://localhost:8080/api/", fallback = UsuarioClientFallback.class)
public interface UsuarioClient {
  @PostMapping("/workers/auth")
  ResponseEntity<TokenDTO> autenticar(@RequestBody CredenciaisDTO credenciaisDTO);

}