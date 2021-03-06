package com.spring_full_api.spring_api.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.spring_full_api.spring_api.Domain.Cliente;
import com.spring_full_api.spring_api.Service.validation.ClienteUpdate;

import org.hibernate.validator.constraints.Length;

@ClienteUpdate
public class ClienteDTO implements Serializable{
    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O nome deve conter entre 5 e 120 caractéres")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;
    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj){
       id = obj.getId();
       nome = obj.getNome();
       email = obj.getEmail(); 
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}