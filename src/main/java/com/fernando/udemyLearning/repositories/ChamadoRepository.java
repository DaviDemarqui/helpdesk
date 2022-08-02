package com.fernando.udemyLearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.udemyLearning.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
