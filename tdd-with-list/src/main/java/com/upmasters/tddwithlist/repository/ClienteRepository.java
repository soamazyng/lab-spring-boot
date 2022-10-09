package com.upmasters.tddwithlist.repository;

import com.upmasters.tddwithlist.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}