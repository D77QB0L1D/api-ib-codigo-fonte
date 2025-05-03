package com.br.desafios.api_ib_codigo_fonte.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
public class Transacao {

    @NotNull
    private String transacao;

    @NotNull
    private OffsetDateTime dataHora;
}
