package com.MinhaLojadeGames.Loja.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MinhaLojadeGames.Loja.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findAllByNomeContaining(String nome);
	List<Produto> findAllByDescricaoContaining(String descricao);
	Optional<Produto> findByNome (String nome);
	Optional<Produto> findByIdProduto(long idProduto);
	
}
