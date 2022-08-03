package com.fernando.udemyLearning.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udemyLearning.domain.Tecnico;
import com.fernando.udemyLearning.repositories.TecnicoRepository;
import com.fernando.udemyLearning.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico FindById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}
}
