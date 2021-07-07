package TesteVendas.Vendas.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDto {
	
	@NotNull(message = "A descrição não pode ser nulo")
	@NotBlank(message = "A decrição precisa conter caracteres")
	private String descricao;
	
	@NotNull(message = "O preço não pode ser nulo")
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
