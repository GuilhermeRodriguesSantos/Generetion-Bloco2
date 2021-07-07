package TesteVendas.Vendas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import TesteVendas.Vendas.dto.UsuarioDTO;
import TesteVendas.Vendas.dto.UsuarioLoginDTO;
import TesteVendas.Vendas.model.Usuario;
import TesteVendas.Vendas.repository.UsuarioRepository;
import TesteVendas.Vendas.services.UsuarioServices;

@RestController
@RequestMapping("/v1/Usuario/")
public class UsuarioController {

	private @Autowired UsuarioRepository repositoryUsuario;
	private @Autowired UsuarioServices serviceUsuario;

	@GetMapping("BuscarTodos")
	public ResponseEntity<List<Usuario>> BuscarTodos() {
		List<Usuario> usuarios = repositoryUsuario.findAll();

		if (usuarios.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(usuarios);
		}
	}

	@GetMapping("BuscarPeloNome")
	public ResponseEntity<List<Usuario>> BuscarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositoryUsuario.findAllByNomeContaining(nome));
	}

	@GetMapping("BuscarPeloEmail")
	public ResponseEntity<List<Usuario>> BuscarPeloEmail(@RequestParam(defaultValue = "") String email) {
		return ResponseEntity.status(200).body(repositoryUsuario.findAllByEmailContaining(email));
	}

	@GetMapping("{idUsuario}/BuscarPeloId")
	public ResponseEntity<Usuario> BuscarPeloId(@PathVariable long idUsuario) {
		return repositoryUsuario.findById(idUsuario).map(existe -> ResponseEntity.ok(existe))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("{idUsuario}/DeletarUsuario")
	public void Deletar(@PathVariable long idUsuario) {
		repositoryUsuario.deleteById(idUsuario);
	}

	@PostMapping("Cadastrar")
	public ResponseEntity<Object> CadastrarUsuario(@RequestBody @Valid Usuario novoUsuario) {
		Optional<Object> cadastro = serviceUsuario.CadastrarUsuario(novoUsuario);

		if (cadastro.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario Existente");
		} else {
			return ResponseEntity.status(201).body("Usuario Criado");
		}
	}
	
	@PutMapping("{idUsuario/AlterarUsuario}")
	public ResponseEntity<Usuario> AlterarUsuario(@PathVariable @Valid long id, @Valid @RequestBody  UsuarioDTO novoUsuario){
		return serviceUsuario.AlterarUsuario(id, novoUsuario).map(usuarioAlterado -> 
			ResponseEntity.status(201).body(usuarioAlterado))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});	
	}
	
	@PutMapping("Credenciais")
	public ResponseEntity<?> pegarCredenciais(@Valid @RequestBody UsuarioLoginDTO dadosLogar){
		return serviceUsuario.Credenciais(dadosLogar)
				.map(usuarioCredencial -> ResponseEntity.ok(usuarioCredencial))
				.orElse(ResponseEntity.badRequest().build());
	}
}
