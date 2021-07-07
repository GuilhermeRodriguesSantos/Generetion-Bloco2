package TesteVendas.Vendas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TesteVendas.Vendas.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByNomeContaining(String nome);

	List<Produto> findAllByDescricaoContaining(String descricao);

	List<Produto> findAllByPrecoContaining(double preco);

	Optional<Produto> findByNome(String nome);
}
