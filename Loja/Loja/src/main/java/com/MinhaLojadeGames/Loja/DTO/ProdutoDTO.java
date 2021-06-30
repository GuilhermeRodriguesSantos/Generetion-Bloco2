package com.MinhaLojadeGames.Loja.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDTO {

	@NotNull(message = "não pode ser nulo")
	@NotBlank(message = "tem que ter caracteres")
	private String nome;

	@NotNull(message = "não pode ser nulo")
	@NotBlank(message = "tem que ter caracteres")
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
