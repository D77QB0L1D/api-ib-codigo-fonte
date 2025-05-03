package com.br.desafios.api_ib_codigo_fonte.service;

import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import com.br.desafios.api_ib_codigo_fonte.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public Transacao processar(Transacao transacao)  {
        transacaoRepository.save(transacao);
        return transacao;
    }
}
