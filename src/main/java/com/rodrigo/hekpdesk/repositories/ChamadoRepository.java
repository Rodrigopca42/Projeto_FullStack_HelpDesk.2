package com.rodrigo.hekpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.hekpdesk.domain.Chamado;


public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
