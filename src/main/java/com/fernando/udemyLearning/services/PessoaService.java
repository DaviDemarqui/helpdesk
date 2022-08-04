package com.fernando.udemyLearning.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fernando.udemyLearning.domain.dtos.PessoaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udemyLearning.domain.Pessoa;
import com.fernando.udemyLearning.repositories.PessoaRepository;
import com.fernando.udemyLearning.services.exceptions.ObjectnotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaDTO FindById(Integer id) {
//		Optional<Pessoa> obj = repository.findById(id);
//		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
		return modelMapper.map(repository.findById(id).orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id)), PessoaDTO.class);
	}

	public List<PessoaDTO> findAll() {
		return repository.findAll().stream().map(obj -> modelMapper.map(obj, PessoaDTO.class)).collect(Collectors.toList());
	}
}
