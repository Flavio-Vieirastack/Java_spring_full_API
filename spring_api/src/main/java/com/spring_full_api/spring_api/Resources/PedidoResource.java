package com.spring_full_api.spring_api.Resources;


import java.net.URI;

import javax.validation.Valid;

import com.spring_full_api.spring_api.Domain.Pedido;
import com.spring_full_api.spring_api.Service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> find (@PathVariable Integer id){

        Pedido obj = service.buscar(id);

        return ResponseEntity.ok().body(obj);

        
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> insert (@Valid @RequestBody Pedido obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(obj.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }
}