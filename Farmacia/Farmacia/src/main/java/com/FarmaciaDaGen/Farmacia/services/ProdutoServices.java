package com.FarmaciaDaGen.Farmacia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FarmaciaDaGen.Farmacia.dto.ProdutoDTO;
import com.FarmaciaDaGen.Farmacia.model.Produto;
import com.FarmaciaDaGen.Farmacia.repository.ProdutoRepository;

@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository repository;

	/**
	 * Fazendo o cadastramento se o nome do produto não existir
	 * 
	 * @param novoProduto , nomeProduto
	 * @return um optional Vazio ou o salvamento
	 * @since 1.0
	 * @author Guilherme Rodrigues
	 */
	public Optional<Object> cadastrar(Produto novoProduto) {
		return repository.findByNome(novoProduto.getNome()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(novoProduto));
		});
	}

	/**
	 * 
	 * @param idProduto
	 * @param produtoAtt
	 * @return um Produto atualizado ou um optional vazio
	 * @since 1.0
	 * @author Guilherme Rorigues
	 */
	public Optional<Produto> Atualizar(long idProduto, ProdutoDTO produtoAtt) {
		return repository.findById(idProduto).map(ProdutoAtualizado -> {
			ProdutoAtualizado.setDescricao(produtoAtt.getDescricao());
			ProdutoAtualizado.setPreco(produtoAtt.getPreco());
			return Optional.ofNullable(repository.save(ProdutoAtualizado));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
