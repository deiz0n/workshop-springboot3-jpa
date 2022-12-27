package com.deiz0ndev.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.deiz0ndev.curso.entidades.Usuario;
import com.deiz0ndev.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Eduardo Silva", "eduardo@gmail.com", "111111111", "132456");
		Usuario u2 = new Usuario(null, "Carlos Nascimento", "carlos@gmail.com", "22222222", "987467");
		
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
	}
	
}
