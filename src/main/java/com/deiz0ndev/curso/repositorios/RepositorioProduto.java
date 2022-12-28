package com.deiz0ndev.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deiz0ndev.curso.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
