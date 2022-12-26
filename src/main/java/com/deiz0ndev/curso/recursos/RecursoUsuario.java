package com.deiz0ndev.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deiz0ndev.curso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

	@GetMapping
	public ResponseEntity<Usuario> buscarTodos() {
		Usuario u = new Usuario(1L, "Eduardo", "eduardo@gmail.com", "123456789", "1234");
		return ResponseEntity.ok().body(u);
	}
	
}
