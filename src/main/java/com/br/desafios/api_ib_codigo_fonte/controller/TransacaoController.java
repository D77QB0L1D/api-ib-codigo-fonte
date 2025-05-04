package com.br.desafios.api_ib_codigo_fonte.controller;

import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import com.br.desafios.api_ib_codigo_fonte.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;


    @GetMapping("/listar")
    public Collection<Transacao> listar() {
        return transacaoService.listar();
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody @Valid Transacao transacao) {
        transacaoService.salvar(new Transacao(transacao.getValor(), transacao.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    public ResponseEntity<Void> limpar() {
        transacaoService.limpar();
        return ResponseEntity.ok().build();
    }

}
