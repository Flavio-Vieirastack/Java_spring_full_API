package com.spring_full_api.spring_api.Domain;

import java.util.Date;

import javax.persistence.Entity;

import com.spring_full_api.spring_api.Domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);

        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public PagamentoComBoleto() {
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
}