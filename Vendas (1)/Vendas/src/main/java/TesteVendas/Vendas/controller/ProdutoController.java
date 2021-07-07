package TesteVendas.Vendas.controller;

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

import TesteVendas.Vendas.dto.ProdutoDto;
import TesteVendas.Vendas.model.Produto;
import TesteVendas.Vendas.repository.ProdutoRepository;
import TesteVendas.Vendas.services.ProdutoServices;

@RestController
@RequestMapping("/v1/Produto/")
public class ProdutoController {

	private @Autowired ProdutoRepository reposutoryProduto;
	private @Autowired ProdutoServices serviceProduto;

	@GetMapping("PegarTodos")
	public ResponseEntity<List<Produto>> PegarTodos() {
		List<Produto> produto = reposutoryProduto.findAll();

		if (produto.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(produto);
		}
	}

	@GetMapping("BuscarPeloNome")
	public ResponseEntity<List<Produto>> PegarPeloNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(reposutoryProduto.findAllByNomeContaining(nome));
	}

	@GetMapping("BuscarPelaDescricao")
	public ResponseEntity<List<Produto>> PegarPelaDescricao(@RequestParam(defaultValue = "") String descricao) {
		return ResponseEntity.status(200).body(reposutoryProduto.findAllByDescricaoContaining(descricao));
	}

	@GetMapping("BuscarPeloPreco")
	public ResponseEntity<List<Produto>> PegarPeloPreco(@RequestParam(defaultValue = "") double preco) {
		return ResponseEntity.status(200).body(reposutoryProduto.findAllByPrecoContaining(preco));
	}

	@GetMapping("{idProduto}/BuscarPeloId")
	public ResponseEntity<Produto> PegarPeloId(@PathVariable long idProduto) {
		return reposutoryProduto.findById(idProduto).map(achou -> ResponseEntity.ok(achou))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("{idProduto}/DeletarProduto")
	public void Deletar(@PathVariable long idProduto) {
		reposutoryProduto.deleteById(idProduto);
	}

	@PostMapping("CadastarProduto")
	public ResponseEntity<Object> CadastrarProduto(@RequestBody @Valid Produto novoProduto) {
		Optional<Object> produto = serviceProduto.CadastrarProduto(novoProduto);

		if (produto.isEmpty()) {
			return ResponseEntity.status(200).body("Produto Existente");
		} else {
			return ResponseEntity.status(201).body("Produto Cadastrado");
		}
	}

	@PutMapping("{idProduto}/AlterarProduto")
	public ResponseEntity<Produto> AlterarProduto(@PathVariable @Valid long idProduto,
			@Valid @RequestBody ProdutoDto novoProduto) {
		return serviceProduto.AlterarProduto(idProduto, novoProduto)
				.map(ProdutoAlterado -> ResponseEntity.status(201).body(reposutoryProduto.save(ProdutoAlterado)))
				.orElseGet(() -> {
					return ResponseEntity.badRequest().build();
				});
	}

}
