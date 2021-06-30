package com.MinhaLojadeGames.Loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinhaLojadeGames.Loja.DTO.CategoriaDto;
import com.MinhaLojadeGames.Loja.model.Categoria;
import com.MinhaLojadeGames.Loja.repository.CategoriaRepository;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository repositoryc;

	public Optional<Object> Cadastar(Categoria novaCategoria) {
		return repositoryc.findByTipo(novaCategoria.getTipo()).map(gategoriaExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repositoryc.save(novaCategoria));
		});
	}

	public Optional<Categoria> Alterar(long idCategoria, CategoriaDto novaCategoria) {
		return repositoryc.findByIdCategoria(idCategoria).map(atualizar -> {
			atualizar.setTipo(novaCategoria.getTipo());
			return Optional.ofNullable(repositoryc.save(atualizar));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}
