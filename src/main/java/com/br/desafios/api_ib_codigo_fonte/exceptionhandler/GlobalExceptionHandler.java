package com.br.desafios.api_ib_codigo_fonte.exceptionhandler;

import com.br.desafios.api_ib_codigo_fonte.util.TransacaoErrosResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TransacaoErrosResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<String> mensagens = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> "Campo '" + e.getField() + "': " + e.getDefaultMessage())
                .toList();

        return ResponseEntity.unprocessableEntity()
                .body(new TransacaoErrosResponse(mensagens));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<TransacaoErrosResponse> handleJsonError(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body(new TransacaoErrosResponse("JSON inválido."));
    }
}
