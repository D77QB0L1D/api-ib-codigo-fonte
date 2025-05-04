package com.br.desafios.api_ib_codigo_fonte.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TransacaoErrosResponse {

    private List<String> erros = new ArrayList<>();

    public TransacaoErrosResponse(String mensagem) {
        this.erros.add(mensagem);
    }

    public TransacaoErrosResponse(List<String> mensagens) {
        this.erros.addAll(mensagens);
    }
}
