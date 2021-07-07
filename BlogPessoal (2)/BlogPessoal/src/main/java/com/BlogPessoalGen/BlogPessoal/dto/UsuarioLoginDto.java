package com.BlogPessoalGen.BlogPessoal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioLoginDto {
	
	private long id;
	private String nome;
	
	@Email(message = "Esse campo precisa ser email")
	@NotBlank(message = "Esse campo não pode ser nulo")
	private String email;
	
	@NotBlank(message = "Esse campo não pode ser nulo")
	private String senha;
	private String token;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
