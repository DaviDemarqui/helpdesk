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
import com.fernando.udemyLearning.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Fernando", "54461705803", "fernando@gmail.com", "12345");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Davi", "87774195025", "davi@yahoo.com", "12345");
		tec2.addPerfil(Perfil.TECNICO);
		
		Cliente cli1 = new Cliente(null, "Moy", "28535894985", "moy@gmail.com", "12345");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1 );
		
		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
