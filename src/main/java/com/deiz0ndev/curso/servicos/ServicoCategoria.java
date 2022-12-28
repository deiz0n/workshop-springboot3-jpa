package com.deiz0ndev.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deiz0ndev.curso.entidades.Categoria;
import com.deiz0ndev.curso.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {

	@Autowired
	private RepositorioCategoria repositorio;
	
	public List<Categoria> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Categoria buscaPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
	
}
