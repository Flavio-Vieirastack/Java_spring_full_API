package com.spring_full_api.spring_api.Service;

import java.util.Optional;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar (Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}