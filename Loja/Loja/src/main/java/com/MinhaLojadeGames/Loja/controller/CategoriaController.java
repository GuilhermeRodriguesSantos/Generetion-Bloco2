package com.MinhaLojadeGames.Loja.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MinhaLojadeGames.Loja.DTO.CategoriaDto;
import com.MinhaLojadeGames.Loja.model.Categoria;
import com.MinhaLojadeGames.Loja.repository.CategoriaRepository;
import com.MinhaLojadeGames.Loja.services.CategoriaServices;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositoryC;

	@Autowired
	private CategoriaServices services;

	@PostMapping("/Cadastar")
	public ResponseEntity<Object> cadastar(@RequestBody @Valid Categoria novaCategoria) {
		Optional<Object> nova = services.Cadastar(novaCategoria);

		if (nova.isEmpty()) {
			return ResponseEntity.status(200).body("Categoria Existente");
		} else {
			return ResponseEntity.status(201).body("Categoria Criada");
		}
	}

	@GetMapping("/PegarTodos")
	public ResponseEntity<List<Categoria>> pegarTodos() {
		return ResponseEntity.status(200).body(repositoryC.findAll());
	}

	@GetMapping("/PegarPeloNome")
	public ResponseEntity<List<Categoria>> BuscarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositoryC.findAllByTipoContaining(nome));
	}

	@GetMapping("/{idCategoria}/PegarPeloID")
	public ResponseEntity<Categoria> BuscarPeloID(@PathVariable long idCategoria) {
		return repositoryC.findById(idCategoria).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{idCategoria}/Alterar")
	public ResponseEntity<Categoria> alterar (@Valid @PathVariable(value = "idCategoria") long idCategoria,
			@Valid @RequestBody CategoriaDto att){
		return services.Alterar(idCategoria, att).map(atutu -> ResponseEntity.status(200).body(atutu))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@DeleteMapping("/{idCategoria}/Deletar")
	public void deletar(@PathVariable long idCategoria) {
		repositoryC.deleteById(idCategoria);
	}
	
}
