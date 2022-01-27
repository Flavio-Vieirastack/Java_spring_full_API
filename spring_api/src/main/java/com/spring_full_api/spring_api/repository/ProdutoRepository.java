package com.spring_full_api.spring_api.repository;

import java.util.List;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.Domain.Produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Transactional(readOnly = true)
    Page<Produto> findDistinctByNomeContainingAndCategoriasIn(
        String nome,
        List<Categoria> categorias,
        Pageable pageRequest
        );
}