package com.spring_full_api.spring_api.Domain;

import javax.persistence.Entity;

import com.spring_full_api.spring_api.Domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
    private Integer numeroDeParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);

        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartao() {
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}