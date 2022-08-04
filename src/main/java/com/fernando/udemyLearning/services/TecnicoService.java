package com.fernando.udemyLearning.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udemyLearning.domain.Pessoa;
import com.fernando.udemyLearning.domain.Tecnico;
import com.fernando.udemyLearning.domain.dtos.TecnicoDTO;
import com.fernando.udemyLearning.repositories.PessoaRepository;
import com.fernando.udemyLearning.repositories.TecnicoRepository;
import com.fernando.udemyLearning.services.exceptions.DataIntegrityViolationException;
import com.fernando.udemyLearning.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	public TecnicoDTO findById(Integer id) {
//		Optional<Tecnico> obj = repository.findById(id);
//		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
		return modelMapper.map(repository.findById(id).orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id)), TecnicoDTO.class);
	}

	public List<TecnicoDTO> findAll() {
		return repository.findAll().stream().map(obj -> modelMapper.map(obj, TecnicoDTO.class)).collect(java.util.stream.Collectors.toList());
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
		
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldObj = repository.findById(id).orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
		Tecnico newObj = modelMapper.map(objDTO, Tecnico.class);
		if(oldObj != null) { newObj.setId(oldObj.getId()); }
		validaPorCpfEEmail(modelMapper.map(objDTO, TecnicoDTO.class));
		oldObj = modelMapper.map(newObj, Tecnico.class);
		return repository.save(oldObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}

	
}
