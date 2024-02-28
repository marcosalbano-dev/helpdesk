package com.idace.helpdesk.services;

import com.idace.helpdesk.domain.enums.Prioridade;
import com.idace.helpdesk.domain.enums.Status;
import com.idace.helpdesk.domain.enums.domain.Chamado;
import com.idace.helpdesk.domain.enums.domain.Cliente;
import com.idace.helpdesk.domain.enums.domain.Tecnico;
import com.idace.helpdesk.dtos.ChamadoDTO;
import com.idace.helpdesk.repositories.ChamadoRepository;
import com.idace.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! " + id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado create(@Valid ChamadoDTO chamadoDTO) {
        return chamadoRepository.save(newChamado(chamadoDTO));
    }

    public Chamado update(Integer id, ChamadoDTO chamadoDTO) {
        chamadoDTO.setId(id);
        Chamado oldChamado = findById(id);
        oldChamado = newChamado(chamadoDTO);
        return chamadoRepository.save(oldChamado);
    }

    private Chamado newChamado(ChamadoDTO chamadoDTO) {
        Tecnico tecnico = tecnicoService.findById(chamadoDTO.getTecnico());
        Cliente cliente = clienteService.findById(chamadoDTO.getCliente());

        Chamado chamado = new Chamado();
        if (chamadoDTO.getId() != null) {
            chamado.setId(chamado.getId());
        }

        if(chamadoDTO.getStatus().equals(2)){
            chamado.setDataFechamento(LocalDate.now());
        }
        if(chamadoDTO.getStatus().equals(0) && chamadoDTO.getStatus().equals(1) && chamadoDTO.getStatus().equals(2) ){
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(chamadoDTO.getPrioridade()));
        chamado.setStatus(Status.toEnum(chamadoDTO.getStatus()));
        chamado.setTitulo(chamadoDTO.getTitulo());
        chamado.setObservacoes(chamadoDTO.getObservacoes());
        return chamado;
    }

}
