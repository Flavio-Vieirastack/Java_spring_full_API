package com.spring_full_api.spring_api.Resources;


import java.net.URI;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.Service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find (@PathVariable Integer id){

        Categoria obj = service.buscar(id);

        return ResponseEntity.ok().body(obj);

        
    }
    @PostMapping
    public ResponseEntity<Void> insert (@RequestBody Categoria obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(obj.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }
}