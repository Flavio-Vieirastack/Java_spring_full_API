package com.spring_full_api.spring_api.Service;

import java.util.Optional;

import com.spring_full_api.spring_api.Domain.Cliente;
import com.spring_full_api.spring_api.Service.exceptions.ObjectNotFoundException;
import com.spring_full_api.spring_api.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find (Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado, Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}