package com.spring_full_api.spring_api.Domain.enums;


public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codigo;
    private String descricao;

    private EstadoPagamento(int code, String descricao) {
        this.codigo = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return codigo;
    }

    public String getEstadoPagamento(){
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer code) {
        if (code != null) {
            for(EstadoPagamento x : EstadoPagamento.values()){
                if(code.equals(x.getCode())) {
                    return x;
                }
            }
        }

        throw new IllegalArgumentException("Id inválido" + code);
    }
}