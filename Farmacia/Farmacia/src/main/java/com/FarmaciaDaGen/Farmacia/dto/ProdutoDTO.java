package com.FarmaciaDaGen.Farmacia.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDTO {

	@NotNull(message = "A descrição não pode ser nulo")
	@NotBlank(message = "A descrição precisa conter caracteres")
	private String descricao;

	@NotNull(message = "O preco não pode ser nulo")
	private double preco;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
