package org.blogPessoal1.blogPessoal.Controller;

import java.util.List;

import javax.validation.Valid;

import org.blogPessoal1.blogPessoal.Model.usuario;
import org.blogPessoal1.blogPessoal.Repository.UsuarioRepository;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	//Adicionar Usuario
	@PostMapping("/Adicionar")
	public ResponseEntity<usuario> adicionar(@Valid @RequestBody usuario novoUsuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}
	
	//Buscabdo todos os usuairios
	@GetMapping("/BuscarTodos")
	public ResponseEntity<List<usuario>> listarTodos(){
		List<usuario> lista = repository.findAll();
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(200).body(lista);
		}
	}
	
	//Buscando os usuarios pelo id
	@GetMapping("/BuscarpeloId/{id}")
	public ResponseEntity<usuario> buscarid(@PathVariable long id){
		return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	//buscando os usuarios pelo nome
	@GetMapping("/BuscarNome/{nome}")
	public ResponseEntity<List<usuario>> buscarNome(@PathVariable String nome){
		return ResponseEntity.status(200).body(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	
	//Alterando o usuario;
	@PutMapping("/Alterar")
	public ResponseEntity<usuario> alterar(@RequestBody usuario alterando){
		return ResponseEntity.status(200).body(repository.save(alterando));
	}
	
	
	//DEletando pelo ID;
	@DeleteMapping("/Deletar/{id}")
	public void deletar(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
