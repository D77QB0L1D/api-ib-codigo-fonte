package com.br.desafios.api_ib_codigo_fonte.service;

import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransacaoService {


    public Queue<Transacao> transacoes = new ConcurrentLinkedDeque<>();

    public void salvar(Transacao transacao)  {
        transacoes.add(transacao);
    }

    public void limpar() {
        transacoes.clear();
    }

    public DoubleSummaryStatistics getEstatistica() {
        OffsetDateTime agora = OffsetDateTime.now();
        DoubleSummaryStatistics statistics  = transacoes.
        stream()
                .filter(t -> t.getDataHora().isAfter(agora.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
        return  statistics;
    }
}
