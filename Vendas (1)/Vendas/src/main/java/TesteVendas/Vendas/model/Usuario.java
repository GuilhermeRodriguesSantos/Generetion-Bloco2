package TesteVendas.Vendas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome precisa conter caracteres")
	private String nome;

	@NotNull(message = "O email não pode ser nulo")
	@NotBlank(message = "O email precisa conter caracteres")
	@Email(message = "O campo precisa conter o @ para dizer que ele é um email")
	private String email;

	@NotNull(message = "A senha não pode ser nulo")
	@NotBlank(message = "A senha precisa conter caracteres")
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Produto> produto = new ArrayList<Produto>();
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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

}
