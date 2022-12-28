package com.deiz0ndev.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deiz0ndev.curso.entidades.Produto;
import com.deiz0ndev.curso.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorio;
	
	public List<Produto> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Produto buscaPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

}
