package com.fernando.udemyLearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.udemyLearning.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
