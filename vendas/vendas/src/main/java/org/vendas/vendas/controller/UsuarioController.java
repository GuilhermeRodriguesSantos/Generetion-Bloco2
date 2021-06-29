package org.vendas.vendas.controller;

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
import org.vendas.vendas.model.Usuario;
import org.vendas.vendas.model.dtos.UsuarioDTO;
import org.vendas.vendas.repository.UsuarioRepository;
import org.vendas.vendas.services.UsuarioServices;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioServices services;

	@PostMapping("/Salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> usuario = services.Cadastar(novoUsuario);

		if (usuario.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario existente");
		} else {
			return ResponseEntity.status(201).body("Usuario Criado");
		}
	}

	@GetMapping("/PegarTodos")
	public ResponseEntity<List<Usuario>> pegarTodos() {
		List<Usuario> usuario = repository.findAll();

		if (usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(usuario);
		}
	}

	@GetMapping("/{id}/PegarPeloId")
	public ResponseEntity<Usuario> buscarid(@PathVariable long id) {
		return repository.findById(id).map(novo -> ResponseEntity.ok(novo)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/BuscandoPorEmail")
	public ResponseEntity<List<Usuario>> pegarPorEmail(@RequestParam(defaultValue = "") String email) {
		return ResponseEntity.status(200).body(repository.findAllByEmailContaining(email));
	}

	@GetMapping("/BuscandoPorNome")
	public ResponseEntity<List<Usuario>> pegarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	@PutMapping("/{id}/Atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @PathVariable(value = "id") Long id,
			@Valid @RequestBody UsuarioDTO usuarioAtualizar) {
		return services.atualizar(id, usuarioAtualizar).map(usuarioAtt -> ResponseEntity.status(201).body(usuarioAtt))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping("{id}/deletar")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
