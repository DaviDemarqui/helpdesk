package com.fernando.udemyLearning.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udemyLearning.domain.Chamado;
import com.fernando.udemyLearning.domain.Cliente;
import com.fernando.udemyLearning.domain.Tecnico;
import com.fernando.udemyLearning.domain.enums.Perfil;
import com.fernando.udemyLearning.domain.enums.Prioridade;
import com.fernando.udemyLearning.domain.enums.Status;
import com.fernando.udemyLearning.repositories.ChamadoRepository;
import com.fernando.udemyLearning.repositories.ClienteRepository;
import com.fernando.udemyLearning.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Fernando", "12345678901", "fernando@gmail.com", "12345");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Moy", "098765432109", "moy@gmail.com", "12345");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1 );
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
