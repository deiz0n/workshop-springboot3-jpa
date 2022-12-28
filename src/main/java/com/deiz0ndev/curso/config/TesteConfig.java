package com.deiz0ndev.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.deiz0ndev.curso.entidades.Categoria;
import com.deiz0ndev.curso.entidades.Pedido;
import com.deiz0ndev.curso.entidades.Produto;
import com.deiz0ndev.curso.entidades.Usuario;
import com.deiz0ndev.curso.entidades.enums.StatusPedido;
import com.deiz0ndev.curso.repositorios.RepositorioCategoria;
import com.deiz0ndev.curso.repositorios.RepositorioPedido;
import com.deiz0ndev.curso.repositorios.RepositorioProduto;
import com.deiz0ndev.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired 
	private RepositorioProduto repositorioProduto;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Eduardo Silva", "eduardo@gmail.com", "111111111", "132456");
		Usuario u2 = new Usuario(null, "Carlos Nascimento", "carlos@gmail.com", "22222222", "987467");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.ENVIADO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T12:21:22Z"), StatusPedido.CANCELADO, u1);
				
		Categoria c1 = new Categoria(null, "Eletrônicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		Produto pro1 = new Produto(null, "O senhos dos anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.50, "");
		Produto pro2 = new Produto(null, "Smart TV", "Tela garnde de alta qualidade", 2190.0, "");
		Produto pro3 = new Produto(null, "Macbook Pro", "Compacto e poderoso", 1260.0, "");
		Produto pro4 = new Produto(null, "PC Gamer", "Alto desempenho para todas as atividades.", 1200.0, "");
		Produto pro5 = new Produto(null, "Trilhos para Dummies", "Cras fringilla convallis sem vel faucibus.", 180.99, "")
				;
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
		repositorioCategoria.saveAll(Arrays.asList(c1, c2, c3));
		repositorioProduto.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));
	}
	
}
