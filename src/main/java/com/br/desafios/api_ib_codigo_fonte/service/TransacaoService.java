package com.br.desafios.api_ib_codigo_fonte.service;

import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;

@Service
public class TransacaoService {

    @Value("${transacao.duracao.segundos}")
    private Long segundos;

    public Collection<Transacao> transacoes = new ArrayList<>();

    public void salvar(Transacao transacao)  {
        transacoes.add(transacao);
    }

    public void limpar() {
        transacoes.clear();
    }

    public Collection<Transacao> listar() {
        return transacoes;
    }

    public DoubleSummaryStatistics getEstatistica() {
        OffsetDateTime agora = OffsetDateTime.now();

        DoubleSummaryStatistics statistics  = transacoes.
        stream()
                .filter(t -> t.getDataHora().isAfter(agora.minusSeconds(segundos)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
        return  statistics;
    }

}
