package com.spring_full_api.spring_api.repository;

import com.spring_full_api.spring_api.Domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    
}