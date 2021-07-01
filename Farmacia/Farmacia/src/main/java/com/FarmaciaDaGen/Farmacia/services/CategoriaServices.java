package com.FarmaciaDaGen.Farmacia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FarmaciaDaGen.Farmacia.dto.CategoriaDTO;
import com.FarmaciaDaGen.Farmacia.model.Categoria;
import com.FarmaciaDaGen.Farmacia.repository.CategoriaRepository;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository repository;

	public Optional<Object> Cadastrar(Categoria novaCategoria) {
		return repository.findByNome(novaCategoria.getNome()).map(CategoriaEx -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(novaCategoria));
		});

	}
	
	public Optional<Categoria> Alterar(long idCategoria, CategoriaDTO novaCategoira){
		return repository.findById(idCategoria).map(CategoriaAtt -> {
			CategoriaAtt.setDescricao(novaCategoira.getDescricao());
			return Optional.ofNullable(repository.save(CategoriaAtt));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
