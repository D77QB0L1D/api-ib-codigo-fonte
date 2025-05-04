package com.br.desafios.api_ib_codigo_fonte.controller;

import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import com.br.desafios.api_ib_codigo_fonte.dto.EstatisticasDTO;
import com.br.desafios.api_ib_codigo_fonte.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> salvar(@RequestBody @Valid Transacao transacao) {
        transacaoService.salvar(new Transacao(transacao.getValor(), transacao.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> limpar() {
        transacaoService.limpar();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasDTO> getEstatisticas() {
        DoubleSummaryStatistics doubleSummaryStatistics = transacaoService.getEstatistica();
        return ResponseEntity.ok(new EstatisticasDTO(doubleSummaryStatistics));
    }
}
