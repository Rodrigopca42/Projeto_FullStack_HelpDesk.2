package com.rodrigo.hekpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.hekpdesk.domain.Chamado;
import com.rodrigo.hekpdesk.domain.Cliente;
import com.rodrigo.hekpdesk.domain.Tecnico;
import com.rodrigo.hekpdesk.domain.enums.Perfil;
import com.rodrigo.hekpdesk.domain.enums.Prioridade;
import com.rodrigo.hekpdesk.domain.enums.Status;
import com.rodrigo.hekpdesk.repositories.ChamadoRepository;
import com.rodrigo.hekpdesk.repositories.ClienteRepository;
import com.rodrigo.hekpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "847.654.620-30", "valdir@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Rodrigo Cardoso", "953.793.990-10", "rodrigo@email.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}
	
}
