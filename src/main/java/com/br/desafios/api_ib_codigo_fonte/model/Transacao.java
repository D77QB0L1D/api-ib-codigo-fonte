package com.br.desafios.api_ib_codigo_fonte.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
public class Transacao {

    @PositiveOrZero
    @NotNull
    private Double transacao;

    @NotNull
    private OffsetDateTime dataHora;
}
