package com.deiz0ndev.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deiz0ndev.curso.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
