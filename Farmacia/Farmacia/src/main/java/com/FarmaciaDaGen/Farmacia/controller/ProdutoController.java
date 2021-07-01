package com.FarmaciaDaGen.Farmacia.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
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

import com.FarmaciaDaGen.Farmacia.dto.ProdutoDTO;
import com.FarmaciaDaGen.Farmacia.model.Produto;
import com.FarmaciaDaGen.Farmacia.repository.ProdutoRepository;
import com.FarmaciaDaGen.Farmacia.services.ProdutoServices;

@RestController
@RequestMapping("/Farmacia")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoServices produtoServices;

	@PostMapping("/Cadastrar")
	public ResponseEntity<Object> Cadastrar(@Valid @RequestBody Produto novoProduto) {
		Optional<Object> produto = produtoServices.cadastrar(novoProduto);

		if (produto.isEmpty()) {
			return ResponseEntity.status(200).body("Produto Existente");
		} else {
			return ResponseEntity.status(201).body("Produto Criado");
		}
	}

	@GetMapping("/BuscarTodos")
	public ResponseEntity<List<Produto>> BuscarTodosProdutos() {
		List<Produto> produto = produtoRepository.findAll();

		if (produto.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(produto);
		}
	}

	@GetMapping("/BuscandoPeloNome")
	public ResponseEntity<List<Produto>> BuscandoPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(produtoRepository.findAllByNomeContaining(nome));
	}

	@GetMapping("/BuscandoPelaDescricao")
	public ResponseEntity<List<Produto>> BuscandoPelaDescricao(@RequestParam(defaultValue = "") String descricao) {
		return ResponseEntity.status(200).body(produtoRepository.findAllByDescricaoContaining(descricao));
	}

	@GetMapping("/{idProduto}/BuscandoPeloId")
	public ResponseEntity<Produto> buscandoPeloID(@PathVariable long idProduto) {
		return produtoRepository.findById(idProduto).map(buscando -> ResponseEntity.ok(buscando))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{idProduto}/Deletar")
	public void Remover(@PathVariable long idProduto) {
		produtoRepository.deleteById(idProduto);

	}
	@PutMapping("/{idProduto}/Alterar")
	public ResponseEntity<Produto> Alterar (@Valid @PathVariable long idUsuario,
			@Valid @RequestBody ProdutoDTO novoProduto){
		return produtoServices.Atualizar(idUsuario, novoProduto).map(att -> ResponseEntity.status(201).body(att))
				.orElse(ResponseEntity.badRequest().build());
	}
}
