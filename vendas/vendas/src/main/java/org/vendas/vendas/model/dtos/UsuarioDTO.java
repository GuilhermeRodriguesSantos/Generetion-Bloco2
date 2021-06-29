package org.vendas.vendas.model.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * datos do usuario para autorizar
 * 
 * @author Guilherme
 *
 */
public class UsuarioDTO {

	@NotNull(message = "não pode ser nulo!")
	@NotBlank(message = "tem que conter algo!")
	private String nome;

	@NotBlank(message = "tem que conter algo!")
	@NotNull(message = "não pode ser nulo!")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
