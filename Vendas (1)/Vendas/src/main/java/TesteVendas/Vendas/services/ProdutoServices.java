package TesteVendas.Vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TesteVendas.Vendas.dto.ProdutoDto;
import TesteVendas.Vendas.model.Produto;
import TesteVendas.Vendas.repository.ProdutoRepository;

@Service
public class ProdutoServices {

	private @Autowired ProdutoRepository repositoryProduto;

	public Optional<Object> CadastrarProduto(Produto novoProduto) {
		return repositoryProduto.findByNome(novoProduto.getNome()).map(ProdutoExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repositoryProduto.save(novoProduto));
		});
	}

	public Optional<Produto> AlterarProduto(long idProduto, ProdutoDto novoProduto) {
		return repositoryProduto.findById(idProduto).map(produtoAlterado -> {
			produtoAlterado.setDescricao(novoProduto.getDescricao());
			produtoAlterado.setPreco(novoProduto.getPreco());
			return Optional.ofNullable(repositoryProduto.save(produtoAlterado));
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}
}
