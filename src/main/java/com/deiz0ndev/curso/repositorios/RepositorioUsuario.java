package com.deiz0ndev.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deiz0ndev.curso.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
