package com.br.desafios.api_ib_codigo_fonte.model;

import com.br.desafios.api_ib_codigo_fonte.validacao.NaoDataFutura;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Setter
@Getter
public class Transacao {

    @PositiveOrZero
    @NotNull
    private Double valor;

    @NaoDataFutura
    @NotNull
    private OffsetDateTime dataHora;

}
