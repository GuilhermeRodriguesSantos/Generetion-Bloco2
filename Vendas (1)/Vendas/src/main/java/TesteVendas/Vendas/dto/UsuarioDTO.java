package TesteVendas.Vendas.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {

	@NotNull(message = "O Nome não pode ser nulo")
	@NotBlank(message = "O Nome precisa conter caracteres")
	private String nome;

	@NotNull(message = "A senha não pode ser nulo")
	@NotBlank(message = "A senha precisa conter caracteres")
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
