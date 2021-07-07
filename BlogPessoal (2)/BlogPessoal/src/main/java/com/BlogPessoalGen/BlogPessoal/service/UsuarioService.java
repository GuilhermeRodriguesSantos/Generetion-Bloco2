package com.BlogPessoalGen.BlogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.BlogPessoalGen.BlogPessoal.dto.UsuarioDTO;
import com.BlogPessoalGen.BlogPessoal.dto.UsuarioLoginDto;
import com.BlogPessoalGen.BlogPessoal.model.UsuarioModel;
import com.BlogPessoalGen.BlogPessoal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private @Autowired UsuarioRepository repositoryUsuario;

	public Optional<Object> CadastrarUsuario(UsuarioModel novoUsuario) {
		return repositoryUsuario.findByEmail(novoUsuario.getEmail()).map(UsuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senha = encoder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(senha);
			return Optional.ofNullable(repositoryUsuario.save(novoUsuario));
		});
	}

	public Optional<UsuarioModel> AlterarUsuario(long idUsuario, UsuarioModel novoUsuario) {

		return repositoryUsuario.findById(idUsuario).map(UsuarioAlterado -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senha = encoder.encode(novoUsuario.getSenha());
			UsuarioAlterado.setNome(novoUsuario.getNome());
			UsuarioAlterado.setSenha(senha);

			return Optional.ofNullable(repositoryUsuario.save(UsuarioAlterado));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	public Optional<?> Logar(UsuarioLoginDto dados) {
		return repositoryUsuario.findByEmail(dados.getEmail()).map(existe -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(dados.getSenha(), existe.getSenha())) {
				String basic = dados.getEmail() + ":" + dados.getSenha();
				byte[] autorizacao = Base64.encodeBase64(basic.getBytes(Charset.forName("US-ASCII")));
				String autorizacaoH = "Basic " + new String(autorizacao);

				dados.setToken(autorizacaoH);
				dados.setId(existe.getIdUsuario());
				dados.setNome(existe.getNome());
				dados.setSenha(existe.getSenha());

				return Optional.ofNullable(dados);
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}
}
