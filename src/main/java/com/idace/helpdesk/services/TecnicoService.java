package com.idace.helpdesk.services;

import com.idace.helpdesk.domain.enums.domain.Pessoa;
import com.idace.helpdesk.domain.enums.domain.Tecnico;
import com.idace.helpdesk.dtos.TecnicoDTO;
import com.idace.helpdesk.repositories.PessoaRepository;
import com.idace.helpdesk.repositories.TecnicoRepository;
import com.idace.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.idace.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null);
        tecnicoDTO.setSenha(encoder.encode(tecnicoDTO.getSenha()));
        validaPorCpfEmail(tecnicoDTO);
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(tecnico);
    }

    public Tecnico update(Integer id, @Valid TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(id);
        Tecnico oldTecnico = findById(id);

        if(!tecnicoDTO.getSenha().equals(oldTecnico.getSenha())){
            tecnicoDTO.setSenha(encoder.encode(oldTecnico.getSenha()));
        }

        validaPorCpfEmail(tecnicoDTO);
        oldTecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(oldTecnico);
    }

    public void delete(Integer id) {
        Tecnico tecnico = findById(id);
        if(tecnico.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        tecnicoRepository.deleteById(id);
    }

    private void validaPorCpfEmail(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(pessoa.isPresent() && pessoa.get().getId() != tecnicoDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        pessoa = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != tecnicoDTO.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }

    }


}
