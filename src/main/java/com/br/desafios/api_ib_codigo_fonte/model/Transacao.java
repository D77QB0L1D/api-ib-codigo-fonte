package com.br.desafios.api_ib_codigo_fonte.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Setter
@Getter
public class Transacao {

    private Double valor;
    private OffsetDateTime dataHora;

}
