package com.deiz0ndev.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deiz0ndev.curso.entidades.Pedido;
import com.deiz0ndev.curso.servicos.ServicoPedido;


@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {

	@Autowired
	private ServicoPedido servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		List<Pedido> list = servico.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscaPorId(@PathVariable Long id){
		Pedido obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
