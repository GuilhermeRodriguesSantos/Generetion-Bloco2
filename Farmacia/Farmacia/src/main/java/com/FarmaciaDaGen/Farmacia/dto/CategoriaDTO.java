package com.FarmaciaDaGen.Farmacia.dto;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {
	
	@NotEmpty(message = "Esse campo não pode ser nulo")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
