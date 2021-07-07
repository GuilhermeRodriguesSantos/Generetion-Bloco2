package com.BlogPessoalGen.BlogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPostagem;
	
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome tem que conter caracteres")
	private String nome;
	
	@NotNull(message = "A descrição não pode ser nulo")
	@NotBlank(message = "A descrição tem que conter caracteres")
	private String descricao;
	
	@ManyToOne()
	private UsuarioModel usuario;

	public long getidPostagem() {
		return idPostagem;
	}

	public void setidPostagem(long idPostagem) {
		this.idPostagem = idPostagem;
	}

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

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
}
