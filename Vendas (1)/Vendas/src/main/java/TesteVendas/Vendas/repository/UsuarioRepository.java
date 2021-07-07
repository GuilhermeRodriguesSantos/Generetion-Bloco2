package TesteVendas.Vendas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TesteVendas.Vendas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findAllByNomeContaining(String nome);

	List<Usuario> findAllByEmailContaining(String email);

	Optional<Usuario> findByEmail(String email);
}
