package com.upmasters.tddwithlist.services;

import com.upmasters.tddwithlist.models.ClienteEntity;
import com.upmasters.tddwithlist.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.upmasters.tddwithlist.helpers.ClienteHelper.doSomethingWithCliente;

@Service
@AllArgsConstructor
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public List<ClienteEntity> getAll(){

    List<ClienteEntity> clienteEntityList;

    clienteEntityList = clienteRepository.findAll();

    return clienteEntityList
        .stream()
        .map(cliente -> {
          if(!cliente.getCpf().isBlank()) {
            doSomethingWithCliente(cliente);
          }
          return cliente;
        }).collect(Collectors.toCollection(ArrayList::new));

  }

}