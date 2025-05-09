package com.br.desafios.api_ib_codigo_fonte.controller;

import com.br.desafios.api_ib_codigo_fonte.dto.EstatisticasDTO;
import com.br.desafios.api_ib_codigo_fonte.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    @Autowired
    private TransacaoService transacaoService;


    @Operation(
            summary = "Obter estatísticas",
            description = "Retorna as estatísticas das transações da aplicação."
    )
    @GetMapping()
    public ResponseEntity<EstatisticasDTO> getEstatisticas() {
        DoubleSummaryStatistics doubleSummaryStatistics = transacaoService.getEstatistica();
        return ResponseEntity.ok(new EstatisticasDTO(doubleSummaryStatistics));
    }
}
