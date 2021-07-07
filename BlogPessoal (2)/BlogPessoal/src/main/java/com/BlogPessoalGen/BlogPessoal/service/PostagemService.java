package com.BlogPessoalGen.BlogPessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlogPessoalGen.BlogPessoal.dto.PostagemDTO;
import com.BlogPessoalGen.BlogPessoal.model.PostagemModel;
import com.BlogPessoalGen.BlogPessoal.repository.PostagemRepository;

@Service
public class PostagemService {
	
	private @Autowired PostagemRepository repository;
	
	public Optional<Object> Cadastar (PostagemModel novaPostagem){
		return repository.findBynome(novaPostagem.getNome()).map(Existente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(novaPostagem));
		});
	}
	
	public Optional<PostagemModel> AlterarPostagem(long idPostagem, PostagemDTO postagem){
		return repository.findById(idPostagem).map(postagemAlterada -> {
			postagemAlterada.setDescricao(postagem.getDescricao());
			return Optional.ofNullable(repository.save(postagemAlterada));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	
	
	
}
