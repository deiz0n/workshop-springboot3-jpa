package com.deiz0ndev.curso.servicos.excecoes;

public class ExcecaoBancoDeDados extends RuntimeException {
    private static final long seriaLVersionUID = 1L;

    public ExcecaoBancoDeDados(String msg) {
        super(msg);
    }
}
