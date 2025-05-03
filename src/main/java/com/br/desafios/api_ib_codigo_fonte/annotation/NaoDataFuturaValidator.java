package com.br.desafios.api_ib_codigo_fonte.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.OffsetDateTime;

public class NaoDataFuturaValidator implements ConstraintValidator<NaoDataFutura, OffsetDateTime> {

    @Override
    public boolean isValid(OffsetDateTime value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return !value.isAfter(OffsetDateTime.now());
    }
}