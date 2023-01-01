package com.deiz0ndev.curso.servicos.excecoes;

public class ExcecaoRecursoNaoEncontrado extends RuntimeException {
    private static final long seriaLVersionUID = 1L;

    public ExcecaoRecursoNaoEncontrado(Object id) {
        super("Recurso não encontrado. Id: " + id);
    }

}
