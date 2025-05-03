package com.br.desafios.api_ib_codigo_fonte.model;

import com.br.desafios.api_ib_codigo_fonte.annotation.NaoDataFutura;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    @NotNull
    private BigDecimal valor;

    @NaoDataFutura
    @NotNull
    private OffsetDateTime dataHora;
}
