package com.br.desafios.api_ib_codigo_fonte.controller;

import com.br.desafios.api_ib_codigo_fonte.input.TransacaoInput;
import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import com.br.desafios.api_ib_codigo_fonte.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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


    @Operation(
     summary = "Listar transações",
     description = "Lista todas as transações registradas na aplicação.")
    @GetMapping("/listar")
    public Collection<Transacao> listar() {
        return transacaoService.listar();
    }

    @Operation(
    summary = "Registrar uma transação",
    description = "Registra uma nova transação com valor e data.")
    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody @Valid TransacaoInput transacaoInput,
    @Parameter(description = "Valor da transação. Deve ser um número positivo.", required = true, example = "100")
    @RequestParam double valor,
    @Parameter(description = "Data da transação no formato ISO-8601 (yyyy-MM-dd'T'HH:mm:ss).", required = true)
    @RequestParam String data) {
        transacaoService.salvar(new Transacao(transacaoInput.getValor(), transacaoInput.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
    summary = "Limpar transações",
    description = "Limpa todas as transações registradas na aplicação.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    public ResponseEntity<Void> limpar() {
        transacaoService.limpar();
        return ResponseEntity.ok().build();
    }

}
