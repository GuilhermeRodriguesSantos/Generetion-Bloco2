package com.MinhaLojadeGames.Loja.controller;

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

import com.MinhaLojadeGames.Loja.DTO.ProdutoDTO;
import com.MinhaLojadeGames.Loja.model.Produto;
import com.MinhaLojadeGames.Loja.repository.ProdutoRepository;
import com.MinhaLojadeGames.Loja.services.ProdutoServices;

@RestController
@RequestMapping("/Loja/Vendas")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositoryProduto;

	@Autowired
	private ProdutoServices services;

	@PostMapping("/Adicionar")
	public ResponseEntity<Object> Cadastrar(@RequestBody @Valid Produto novoProduto) {
		Optional<Object> produtos = services.Cadastrar(novoProduto);

		if (produtos.isEmpty()) {
			return ResponseEntity.status(200).body("Produto Existente");
		} else {
			return ResponseEntity.status(201).body("Produto Criado");
		}
	}

	@GetMapping("/PegarTodos")
	public ResponseEntity<List<Produto>> BuscandoTodosProdutos() {
		List<Produto> Produtos = repositoryProduto.findAll();

		if (Produtos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(Produtos);
		}
	}

	@GetMapping("{idProduto}/BuscarpeloId")
	public ResponseEntity<Produto> BuscarPeloId(@PathVariable long idProduto) {
		return repositoryProduto.findById(idProduto).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/BuscarNome")
	public ResponseEntity<List<Produto>> BucarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositoryProduto.findAllByNomeContaining(nome));
	}

	@GetMapping("/BuscarDescricao")
	public ResponseEntity<List<Produto>> PegarPelaDecricao(@RequestParam(defaultValue = "") String descricao) {
		return ResponseEntity.status(200).body(repositoryProduto.findAllByDescricaoContaining(descricao));
	}
	
	@PutMapping("/{idProduto}/Alterar")
	public ResponseEntity<Produto> alterar (@Valid @PathVariable(value = "idProduto") long idProduto,
			@Valid @RequestBody ProdutoDTO atualizar){
		
		return services.atualizarProduto(idProduto, atualizar).map(atutu -> ResponseEntity.status(200).body(atutu))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	 @DeleteMapping("{idProduto}/Deletar")
	 public void deletar(@PathVariable long idProduto) {
		 repositoryProduto.deleteById(idProduto);
	}
	
}
