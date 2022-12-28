package com.rodrigo.hekpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.hekpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
