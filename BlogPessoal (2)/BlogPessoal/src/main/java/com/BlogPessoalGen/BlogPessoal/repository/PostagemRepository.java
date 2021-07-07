package com.BlogPessoalGen.BlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlogPessoalGen.BlogPessoal.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long>{
	
	List<PostagemModel> findAllByNomeContaining(String nome);
	List<PostagemModel> findAllByDescricaoContaining(String descricao);
	Optional<PostagemModel> findBynome(String nome);
}
