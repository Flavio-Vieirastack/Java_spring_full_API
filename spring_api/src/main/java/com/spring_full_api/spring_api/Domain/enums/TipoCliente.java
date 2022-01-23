package com.spring_full_api.spring_api.Domain.enums;


public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa física"),
    PESSOA_JURIDICA(2, "Pessoa jurídica");

    private int codigo;
    private String descricao;

    private TipoCliente(int code, String descricao) {
        this.codigo = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return codigo;
    }

    public String getDescricao(){
        return descricao;
    }

    public static TipoCliente toEnum(Integer code) {
        if (code != null) {
            for(TipoCliente x : TipoCliente.values()){
                if(code.equals(x.getCode())) {
                    return x;
                }
            }
        }

        throw new IllegalArgumentException("Id inválido" + code);
    }
}