package org.vendas.vendas.controller;

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
import org.vendas.vendas.model.Compra;
import org.vendas.vendas.model.dtos.CompraDTO;
import org.vendas.vendas.repository.CompraRepository;
import org.vendas.vendas.services.CompraServices;

@RestController
@RequestMapping("/Compras")
public class CompraController {

	@Autowired
	private CompraRepository repository;

	@Autowired
	private CompraServices services;

	@PostMapping("/Salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Compra novaCompra) {
		Optional<Object> compra = services.Cadastar(novaCompra);

		if (compra.isEmpty()) {
			return ResponseEntity.status(200).body("usuario existente");
		} else {
			return ResponseEntity.status(201).body("usuario Criado");
		}
	}

	@GetMapping("/BuscarTodos")
	public ResponseEntity<List<Compra>> pegarTodas() {
		return ResponseEntity.ok(repository.findAll());
	}

	/*
	 * @GetMapping public ResponseEntity<Compra> pegarPeloID (@PathVariable long
	 * id){ return repository.findById(id) .map(novo -> ResponseEntity.ok(novo))
	 * .orElse(ResponseEntity.notFound().build()); }
	 */

	@GetMapping("/BuscarPeloNome")
	public ResponseEntity<List<Compra>> buscarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repository.findAllBynomeContaining(nome));
	}

	@GetMapping("/{id}/BuscarPeloId")
	public ResponseEntity<Compra> buscarPeloID(@PathVariable Long id) {
		return repository.findById(id).map(novo -> ResponseEntity.ok(novo)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}/Atualizar")
	public ResponseEntity<Compra> atualizar(@Valid @PathVariable (value = "id") Long id,
			@Valid @RequestBody CompraDTO compraAtualizar){
		return services.atualizar(id, compraAtualizar).map(att -> ResponseEntity.status(201).body(att))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@DeleteMapping("/{id}/Deletar")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
