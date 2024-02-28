package com.idace.helpdesk.repositories;

import com.idace.helpdesk.domain.enums.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
