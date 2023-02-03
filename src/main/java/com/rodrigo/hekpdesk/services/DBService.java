package com.rodrigo.hekpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rodrigo.hekpdesk.domain.Chamado;
import com.rodrigo.hekpdesk.domain.Cliente;
import com.rodrigo.hekpdesk.domain.Tecnico;
import com.rodrigo.hekpdesk.domain.enums.Perfil;
import com.rodrigo.hekpdesk.domain.enums.Prioridade;
import com.rodrigo.hekpdesk.domain.enums.Status;
import com.rodrigo.hekpdesk.repositories.ChamadoRepository;
import com.rodrigo.hekpdesk.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "847.654.620-30", "valdir@email.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Rodrigo Cardoso", "953.793.990-10", "rodrigo@email.com", encoder.encode("123"));
		cli1.addPerfil(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		pessoaRepository.saveAll(Arrays.asList(tec1));
		pessoaRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}
	
}
