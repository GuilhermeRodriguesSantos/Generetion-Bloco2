package com.MinhaLojadeGames.Loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinhaLojadeGames.Loja.DTO.ProdutoDTO;
import com.MinhaLojadeGames.Loja.model.Produto;
import com.MinhaLojadeGames.Loja.repository.ProdutoRepository;

@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository repositoryProduto;

	/**
	 * 
	 * @param novoProduto
	 * @return um optional vazio ou salvar um usuario
	 */
	public Optional<Object> Cadastrar(Produto novoProduto) {
		return repositoryProduto.findByNome(novoProduto.getNome()).map(ProdutoExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repositoryProduto.save(novoProduto));
		});
	}

	public Optional<Produto> atualizarProduto(Long idProduto, ProdutoDTO novo) {
		return repositoryProduto.findByIdProduto(idProduto).map(atualizar -> {
			atualizar.setNome(novo.getNome());
			atualizar.setDescricao(novo.getDescricao());
			return Optional.ofNullable(repositoryProduto.save(atualizar));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}
