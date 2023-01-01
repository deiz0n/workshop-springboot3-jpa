package com.deiz0ndev.curso.recursos.excecoes;

import com.deiz0ndev.curso.servicos.excecoes.ExcecaoRecursoNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExcecaoRecursoManual {

    @ExceptionHandler(ExcecaoRecursoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> excecaoRecursoNaoEncontrado(ExcecaoRecursoNaoEncontrado e, HttpServletRequest requisicao) {
        String erro = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), requisicao.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
