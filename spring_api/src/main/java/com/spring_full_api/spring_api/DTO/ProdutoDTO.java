package com.spring_full_api.spring_api.DTO;

import java.io.Serializable;

import com.spring_full_api.spring_api.Domain.Produto;

public class ProdutoDTO implements Serializable {
    private Integer id;
    private String nome;
    private Double preco;
    public ProdutoDTO() {
    }
    public ProdutoDTO(Produto obj){
        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();
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
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
} //parei em 3.42