package com.spring_full_api.spring_api.repository;

import com.spring_full_api.spring_api.Domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}