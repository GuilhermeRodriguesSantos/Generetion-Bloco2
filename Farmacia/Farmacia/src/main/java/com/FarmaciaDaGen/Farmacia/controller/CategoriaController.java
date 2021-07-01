package com.FarmaciaDaGen.Farmacia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.FarmaciaDaGen.Farmacia.dto.CategoriaDTO;
import com.FarmaciaDaGen.Farmacia.model.Categoria;
import com.FarmaciaDaGen.Farmacia.repository.CategoriaRepository;
import com.FarmaciaDaGen.Farmacia.services.CategoriaServices;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaServices services;

	@Autowired
	private CategoriaRepository repository;

	@PostMapping("/postar")
	public ResponseEntity<Object> Cadastar(@Valid @RequestBody Categoria novaCategoria) {
		Optional<Object> categoria = services.Cadastrar(novaCategoria);

		if (categoria.isEmpty()) {
			return ResponseEntity.status(200).body("Categoria Existente");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("categoria Cadastrada");
		}
	}

	@GetMapping("/PegarTodos")
	public ResponseEntity<List<Categoria>> BuscarTodos() {
		List<Categoria> categoria = repository.findAll();

		if (categoria.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(categoria);
		}

	}

	@GetMapping("/BuscarPeloNome")
	public ResponseEntity<List<Categoria>> PegarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	@GetMapping("/BuscarPelaDescricao")
	public ResponseEntity<List<Categoria>> PegarPelaDescricao(@RequestParam(defaultValue = "") String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}

	@GetMapping("/{idCategoria/BuscarPeloID}")
	public ResponseEntity<Categoria> BuscarPeloId(@PathVariable long idCategoria) {
		return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{idCategoria}/Remover")
	public void Deletar(@PathVariable long idCategoria) {
		repository.deleteById(idCategoria);
	}

	@PutMapping("/{idCategoria}/Alterar")
	public ResponseEntity<Categoria> Alterar(@Valid @PathVariable long idCategoria,
			@Valid @RequestBody CategoriaDTO novaCategoiria) {
		return services.Alterar(idCategoria, novaCategoiria).map(novo -> ResponseEntity.status(201).body(novo))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}

}
