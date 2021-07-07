package com.BlogPessoalGen.BlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.BlogPessoalGen.BlogPessoal.model.UsuarioModel;

@Service
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	List<UsuarioModel> findAllByNomeContaining(String nome);

	List<UsuarioModel> findAllByEmailContaining(String email);

	Optional<UsuarioModel> findByEmail(String email);
}
