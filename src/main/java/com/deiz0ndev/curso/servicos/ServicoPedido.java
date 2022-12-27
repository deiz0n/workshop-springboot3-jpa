package com.deiz0ndev.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deiz0ndev.curso.entidades.Pedido;
import com.deiz0ndev.curso.repositorios.RepositorioPedido;

@Service
public class ServicoPedido {

	@Autowired
	private RepositorioPedido repositorio;
	
	public List<Pedido> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Pedido buscarPorId(Long Id) {
		Optional<Pedido> obj = repositorio.findById(Id);
		return obj.get();
	}
}
