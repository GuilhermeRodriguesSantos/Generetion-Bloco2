package com.BlogPessoalGen.BlogPessoal.controller;

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
import com.BlogPessoalGen.BlogPessoal.dto.PostagemDTO;
import com.BlogPessoalGen.BlogPessoal.model.PostagemModel;
import com.BlogPessoalGen.BlogPessoal.repository.PostagemRepository;
import com.BlogPessoalGen.BlogPessoal.service.PostagemService;

@RestController
@RequestMapping("/v1/Postagem/")
public class PostagemController {

	private @Autowired PostagemRepository repositoryPostagem;
	private @Autowired PostagemService service;

	@PostMapping("Cadastrar")
	public ResponseEntity<Object> Cadastrar(@Valid @RequestBody PostagemModel novaPostagem) {
		Optional<Object> postagem = service.Cadastar(novaPostagem);

		if (postagem.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario Existente");
		} else {
			return ResponseEntity.status(201).body("Usuario Criado");
		}
	}

	@PutMapping("{idPostagem}/Alterar")
	public ResponseEntity<PostagemModel> Alterar(@Valid @PathVariable long idPostagem,
			@Valid @RequestBody PostagemDTO postagem) {
		return service.AlterarPostagem(idPostagem, postagem)
				.map(alterado -> ResponseEntity.status(201).body(repositoryPostagem.save(alterado))).orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});

	}

	@GetMapping("BuscarTodos")
	public ResponseEntity<List<PostagemModel>> BucarTodos() {
		List<PostagemModel> postagens = repositoryPostagem.findAll();

		if (postagens.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} else {
			return ResponseEntity.status(200).body(postagens);
		}

	}

	@GetMapping("BuscarPeloNome")
	public ResponseEntity<List<PostagemModel>> BuscarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositoryPostagem.findAllByNomeContaining(nome));
	}

	@GetMapping("BuscarPelaDescricao")
	public ResponseEntity<List<PostagemModel>> BuscarPelaDescricao(@RequestParam(defaultValue = "") String descricao) {
		return ResponseEntity.status(200).body(repositoryPostagem.findAllByDescricaoContaining(descricao));
	}

	@GetMapping("{idPostagem}BuscarPeloId")
	public ResponseEntity<PostagemModel> BuscarPeloId(@PathVariable long idPostagem) {
		return repositoryPostagem.findById(idPostagem).map(achou -> ResponseEntity.ok(achou))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("{idPostagem}/Deletar")
	public void Deletar(@PathVariable long idPostagem) {
		repositoryPostagem.deleteById(idPostagem);
	}
}
