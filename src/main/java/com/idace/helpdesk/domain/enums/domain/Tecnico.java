package com.idace.helpdesk.domain.enums.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idace.helpdesk.domain.enums.Perfil;
import com.idace.helpdesk.dtos.TecnicoDTO;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends Pessoa {
    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    List<Chamado> chamados = new ArrayList<>();
    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(TecnicoDTO tecnicoDTO) {
        super();
        this.id = tecnicoDTO.getId();
        this.nome = tecnicoDTO.getNome();
        this.cpf = tecnicoDTO.getCpf();
        this.email = tecnicoDTO.getEmail();
        this.senha = tecnicoDTO.getSenha();
        this.perfis = tecnicoDTO.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = tecnicoDTO.getDataCriacao();
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
