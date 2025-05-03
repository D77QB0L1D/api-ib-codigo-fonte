package com.br.desafios.api_ib_codigo_fonte.controller;

import com.br.desafios.api_ib_codigo_fonte.exception.TransacaoExceptionNegocio;
import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import com.br.desafios.api_ib_codigo_fonte.repository.TransacaoRepository;
import com.br.desafios.api_ib_codigo_fonte.service.TransacaoService;
import com.br.desafios.api_ib_codigo_fonte.util.TransacaoErrosResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<?> criar(@RequestBody @Valid Transacao transacao) {
        transacaoService.processar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
