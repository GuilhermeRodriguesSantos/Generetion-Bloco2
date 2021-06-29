package org.vendas.vendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vendas.vendas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

	List<Usuario> findAllByEmailContaining(String email);

	List<Usuario> findAllByNomeContaining(String nome);
}
