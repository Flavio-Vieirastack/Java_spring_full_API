package com.spring_full_api.spring_api.Resources;

import java.util.ArrayList;
import java.util.List;

import com.spring_full_api.spring_api.Domain.Categoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @GetMapping
    public List<Categoria> listar (){

        Categoria cat1 = new Categoria(1, "informática");
        Categoria cat2 = new Categoria(2, "escritorio");

        List<Categoria> lista = new ArrayList<Categoria>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
}