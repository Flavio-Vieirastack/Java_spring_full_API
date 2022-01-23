package com.spring_full_api.spring_api.Resources;


import com.spring_full_api.spring_api.Domain.Cliente;
import com.spring_full_api.spring_api.Service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find (@PathVariable Integer id){

        Cliente obj = service.buscar(id);

        return ResponseEntity.ok().body(obj);

        
    }
}