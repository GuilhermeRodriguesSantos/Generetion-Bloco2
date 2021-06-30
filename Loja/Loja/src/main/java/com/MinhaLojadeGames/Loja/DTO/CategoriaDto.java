package com.MinhaLojadeGames.Loja.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDto {

	@NotNull(message = "O tipo não pode ser nulo")
	@NotBlank(message = "ELe tem que conter caracteres")
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
