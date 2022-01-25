package com.spring_full_api.spring_api.Service;

import java.util.Optional;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.Service.exceptions.ObjectNotFoundException;
import com.spring_full_api.spring_api.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find (Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado, Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert (Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update (Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }
}