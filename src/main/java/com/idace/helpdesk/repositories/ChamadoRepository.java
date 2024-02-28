package com.idace.helpdesk.repositories;

import com.idace.helpdesk.domain.enums.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
