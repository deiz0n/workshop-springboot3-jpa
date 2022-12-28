package com.deiz0ndev.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deiz0ndev.curso.entidades.Produto;
import com.deiz0ndev.curso.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {

	@Autowired
	private ServicoProduto servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> list = servico.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto obj = servico.buscaPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
