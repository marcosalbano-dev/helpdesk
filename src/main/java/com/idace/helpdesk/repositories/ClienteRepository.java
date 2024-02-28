package com.idace.helpdesk.repositories;

import com.idace.helpdesk.domain.enums.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
