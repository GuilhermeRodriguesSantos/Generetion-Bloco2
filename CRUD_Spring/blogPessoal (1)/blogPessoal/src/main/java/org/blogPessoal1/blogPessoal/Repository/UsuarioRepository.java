package org.blogPessoal1.blogPessoal.Repository;

import java.util.List;

import org.blogPessoal1.blogPessoal.Model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<usuario, Long>{
	public List<usuario> findAllByNomeContainingIgnoreCase(String nome);
}
