package com.deiz0ndev.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.deiz0ndev.curso.entidades.Pedido;
import com.deiz0ndev.curso.entidades.Usuario;
import com.deiz0ndev.curso.entidades.enums.StatusPedido;
import com.deiz0ndev.curso.repositorios.RepositorioPedido;
import com.deiz0ndev.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Eduardo Silva", "eduardo@gmail.com", "111111111", "132456");
		Usuario u2 = new Usuario(null, "Carlos Nascimento", "carlos@gmail.com", "22222222", "987467");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.ENVIADO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T12:21:22Z"), StatusPedido.CANCELADO, u1);
				
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
