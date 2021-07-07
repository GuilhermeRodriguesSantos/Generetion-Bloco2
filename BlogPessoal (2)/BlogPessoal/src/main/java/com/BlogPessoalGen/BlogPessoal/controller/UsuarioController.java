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

import com.BlogPessoalGen.BlogPessoal.dto.UsuarioLoginDto;
import com.BlogPessoalGen.BlogPessoal.model.UsuarioModel;
import com.BlogPessoalGen.BlogPessoal.repository.UsuarioRepository;
import com.BlogPessoalGen.BlogPessoal.service.UsuarioService;

@RestController
@RequestMapping("/v1/UsuarioBlog/")
public class UsuarioController {

	private @Autowired UsuarioRepository repositoryUsuario;
	private @Autowired UsuarioService serviceUsuario;

	@PostMapping("Cadastar")
	public ResponseEntity<Object> CadastrarUsuario(@RequestBody @Valid UsuarioModel novoUsuario) {
		Optional<Object> usuarios = serviceUsuario.CadastrarUsuario(novoUsuario);

		if (usuarios.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario Existente");
		} else {
			return ResponseEntity.status(201).body("Usuario Criado");
		}
	}
	

	@PutMapping("{idUsuario}/AlterarUsuario")
	public ResponseEntity<UsuarioModel> AlterarUsuario(@Valid @PathVariable long idUsuario,
			@Valid @RequestBody UsuarioModel novoUsuario) {
		return serviceUsuario.AlterarUsuario(idUsuario, novoUsuario)
				.map(UsuarioAlterado -> ResponseEntity.status(201).body(repositoryUsuario.save(UsuarioAlterado)))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}

	@GetMapping("BuscarTodos")
	public ResponseEntity<List<UsuarioModel>> BuscarTodos() {
		List<UsuarioModel> usuarios = repositoryUsuario.findAll();

		if (usuarios.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(usuarios);
		}
	}

	@GetMapping("BuscarPeloNome")
	public ResponseEntity<List<UsuarioModel>> BuscarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositoryUsuario.findAllByNomeContaining(nome));
	}

	@GetMapping("BuscarPeloEmail")
	public ResponseEntity<List<UsuarioModel>> BuscarPeloEmail(@RequestParam(defaultValue = "") String email) {
		return ResponseEntity.status(200).body(repositoryUsuario.findAllByEmailContaining(email));
	}

	@GetMapping("{idUsuario}/BuscarPeloId")
	public ResponseEntity<UsuarioModel> BuscarPeloId(@PathVariable long idUsuario) {
		return repositoryUsuario.findById(idUsuario).map(Achou -> ResponseEntity.ok(Achou))
				.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}

	@DeleteMapping("{idUsuario}/Deletar")
	public void Deletar(@PathVariable long idUsuario) {
		repositoryUsuario.deleteById(idUsuario);
	}
	
	@PutMapping("Logar")
	public ResponseEntity<?> logar (@Valid @RequestBody UsuarioLoginDto logar){
		return serviceUsuario.Logar(logar)
				.map(usuario -> ResponseEntity.ok(usuario))
				.orElse(ResponseEntity.badRequest().build());
		
	}
}
