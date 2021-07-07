package com.BlogPessoalGen.BlogPessoal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostagemDTO {
	
	@NotNull(message = "A descrição não pode ser nulo")
	@NotBlank(message = "A descrição tem que conter caracteres")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
