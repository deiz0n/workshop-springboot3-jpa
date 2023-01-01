package com.deiz0ndev.curso.servicos;

import java.util.List;
import java.util.Optional;

import com.deiz0ndev.curso.servicos.excecoes.ExcecaoRecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deiz0ndev.curso.entidades.Usuario;
import com.deiz0ndev.curso.repositorios.RepositorioUsuario;


@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscaPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(id));
	}

	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}

	public void deletar(Long id) {
		repositorio.deleteById(id);
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario entidade = repositorio.getReferenceById(id);
		atualizarDados(entidade, usuario);
		return repositorio.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setEmail(usuario.getEmail());
		entidade.setTelefone(usuario.getTelefone());
	}

}
