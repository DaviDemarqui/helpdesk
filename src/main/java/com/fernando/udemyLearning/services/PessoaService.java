package com.fernando.udemyLearning.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udemyLearning.domain.Pessoa;
import com.fernando.udemyLearning.repositories.PessoaRepository;
import com.fernando.udemyLearning.services.exceptions.ObjectnotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public Pessoa FindById(Integer id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}
}
