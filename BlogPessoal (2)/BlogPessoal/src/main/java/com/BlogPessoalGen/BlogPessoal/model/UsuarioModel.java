package com.BlogPessoalGen.BlogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	/**
	 * Definindo os pares e valores da entidade Usuario
	 * @author Guilherme Rodrigues
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome tem que conter caracteres")
	private String nome;

	@NotNull(message = "O email não pode ser nulo")
	@NotBlank(message = "O email tem que conter caracteres")
	@Email(message = "O email precisa ter o @ pra dizer que é um email")
	private String email;

	@NotNull(message = "A senha não pode ser nula")
	@NotBlank(message = "A senha precisa conter caracteres")
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private List<PostagemModel> postagem = new ArrayList<>();

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
