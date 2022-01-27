package com.spring_full_api.spring_api.Service;

import java.util.List;
import java.util.Optional;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.Domain.Produto;
import com.spring_full_api.spring_api.Service.exceptions.ObjectNotFoundException;
import com.spring_full_api.spring_api.repository.CategoriaRepository;
import com.spring_full_api.spring_api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto buscar(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado, Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> search(
        String nome,
        List<Integer> ids,
        Integer page,
        Integer linesPerPage,
        String orderBy,
        String direction
        ) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
        
    }
}
