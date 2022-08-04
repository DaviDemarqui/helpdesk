package com.fernando.udemyLearning.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.udemyLearning.domain.Pessoa;
import com.fernando.udemyLearning.domain.dtos.PessoaDTO;
import com.fernando.udemyLearning.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(service.FindById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

}
