package com.idace.helpdesk.resources;

import com.idace.helpdesk.domain.enums.domain.Cliente;
import com.idace.helpdesk.dtos.ClienteDTO;
import com.idace.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value =  "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        Cliente cliente = this.clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDTO(cliente));
    }
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> list = clienteService.findAll();
        List<ClienteDTO> listDTO = list.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.create(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("${id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.update(id, clienteDTO);
        return ResponseEntity.ok().body(new ClienteDTO(cliente));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
