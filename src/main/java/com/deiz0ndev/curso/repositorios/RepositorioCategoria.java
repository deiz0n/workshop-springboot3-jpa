package com.deiz0ndev.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deiz0ndev.curso.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
