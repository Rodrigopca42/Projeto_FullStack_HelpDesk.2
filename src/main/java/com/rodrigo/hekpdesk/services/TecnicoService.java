package com.rodrigo.hekpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.hekpdesk.domain.Tecnico;
import com.rodrigo.hekpdesk.domain.dtos.TecnicoDTO;
import com.rodrigo.hekpdesk.repositories.TecnicoRepository;
import com.rodrigo.hekpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID: "+ id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

}














