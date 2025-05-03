package com.br.desafios.api_ib_codigo_fonte.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NaoDataFuturaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NaoDataFutura {

    String message() default "A data não pode estar no futuro.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}