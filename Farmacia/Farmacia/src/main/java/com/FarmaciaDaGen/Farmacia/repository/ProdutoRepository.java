package com.FarmaciaDaGen.Farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FarmaciaDaGen.Farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findByIdProduto(Long idProduto);
	List<Produto> findAllByNomeContaining(String nome);
	List<Produto> findAllByDescricaoContaining(String descricao);
	
	Optional<Produto> findByNome(String nome);

}
