package com.fernando.udemyLearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.udemyLearning.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
