package com.upmasters.tddwithlist.services;

import com.upmasters.tddwithlist.models.ClienteEntity;
import com.upmasters.tddwithlist.repository.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class ClienteServiceTests {

  @InjectMocks
  ClienteService clienteService;

  @Mock
  ClienteRepository clienteRepository;

  @Test
  @DisplayName("Deve obter todos os dados do cliente")
  void getAllTest(){

    ClienteEntity clienteEntity = new ClienteEntity();
    clienteEntity.setNome("Jaqueline");
    clienteEntity.setCpf("22389086845");

    List<ClienteEntity> clienteEntityList = new ArrayList<>();
    clienteEntityList.add(clienteEntity);

    when(clienteRepository.findAll()).thenReturn(clienteEntityList);

    var result = clienteService.getAll();

    assertThat( result, contains(
        hasProperty("segundoNome", is("Benedicto"))
    ));

  }

}