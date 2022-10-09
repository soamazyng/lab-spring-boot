package com.upmasters.tddwithlist.helpers;

import com.upmasters.tddwithlist.models.ClienteEntity;

public class ClienteHelper {

  public static ClienteEntity doSomethingWithCliente(ClienteEntity clienteEntity){

    clienteEntity.setSegundoNome("Benedicto");

    return clienteEntity;

  }

}