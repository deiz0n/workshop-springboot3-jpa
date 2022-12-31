package com.deiz0ndev.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deiz0ndev.curso.entidades.ItemsPedido;


public interface RepositorioItemPedido extends JpaRepository<ItemsPedido, Long> {

}
