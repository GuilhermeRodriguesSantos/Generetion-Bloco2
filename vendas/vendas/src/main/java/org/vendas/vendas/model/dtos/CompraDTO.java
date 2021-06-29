package org.vendas.vendas.model.dtos;

import javax.validation.constraints.NotNull;

public class CompraDTO {
	/**
	 * Dados para atualizar
	 * 
	 * @author Guilherme
	 */

	@NotNull(message = "Não pode ser nulo")
	private String nome;

	@NotNull(message = "Não pode ser nulo")
	private double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
