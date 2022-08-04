package com.fernando.udemyLearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.udemyLearning.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
