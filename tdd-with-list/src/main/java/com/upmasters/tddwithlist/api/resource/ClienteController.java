package com.upmasters.tddwithlist.api.resource;

import com.upmasters.tddwithlist.models.ClienteEntity;
import com.upmasters.tddwithlist.repository.ClienteRepository;
import com.upmasters.tddwithlist.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {

  private final ClienteRepository clienteRepository;
  private final ClienteService clienteService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Void> create(){

    var cliente = ClienteEntity
        .builder()
        .nome("Jaqueline")
            .cpf("22389086845")
                .build();


    clienteRepository.save(cliente);

    var cliente2 = ClienteEntity
        .builder()
        .nome("Lucy")
        .cpf("22389086840")
        .build();

    clienteRepository.save(cliente2);

    return ResponseEntity.ok().build();

  }

  @GetMapping
  public ResponseEntity<List<ClienteEntity>> getAll(){

    return ResponseEntity.ok(clienteService.getAll());

  }

}