package com.idace.helpdesk.services;

import com.idace.helpdesk.domain.enums.domain.Pessoa;
import com.idace.helpdesk.domain.enums.domain.Cliente;
import com.idace.helpdesk.dtos.ClienteDTO;
import com.idace.helpdesk.repositories.ClienteRepository;
import com.idace.helpdesk.repositories.PessoaRepository;
import com.idace.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.idace.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO clienteDTO) {
        clienteDTO.setId(null);
        clienteDTO.setSenha(encoder.encode(clienteDTO.getSenha()));
        validaPorCpfEmail(clienteDTO);
        Cliente cliente = new Cliente(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Integer id, @Valid ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Cliente oldCliente = findById(id);

        if(!clienteDTO.getSenha().equals(oldCliente.getSenha())){
            clienteDTO.setSenha(encoder.encode(oldCliente.getSenha()));
        }
        validaPorCpfEmail(clienteDTO);
        oldCliente = new Cliente(clienteDTO);
        return clienteRepository.save(oldCliente);
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);
        if(cliente.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        clienteRepository.deleteById(id);
    }

    private void validaPorCpfEmail(ClienteDTO clienteDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if(pessoa.isPresent() && pessoa.get().getId() != clienteDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        pessoa = pessoaRepository.findByEmail(clienteDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != clienteDTO.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }

    }


}
