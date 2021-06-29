package org.vendas.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vendas.vendas.model.Usuario;
import org.vendas.vendas.model.dtos.UsuarioDTO;
import org.vendas.vendas.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repository;

	/**
	 * 
	 * @param novoUsuario;
	 * @return um usuario existente ou um optional vazio;
	 * @since verão 1.0;
	 * @author Guilherme;
	 */
	public Optional<Object> Cadastar(Usuario novoUsuario) {
		return repository.findByEmail(novoUsuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(novoUsuario));
		});
	}

	/**
	 * 
	 * @param id
	 * @param usuarioAtualizar
	 * @return
	 * @since 1.0
	 * @author Guilherme
	 */
	public Optional<Usuario> atualizar(Long id, UsuarioDTO usuarioAtualizar) {
		return repository.findById(id).map(usuarionovo -> {
			usuarionovo.setNome(usuarioAtualizar.getNome());
			usuarionovo.setSenha(usuarioAtualizar.getSenha());
			return Optional.ofNullable(repository.save(usuarionovo));
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}
}
