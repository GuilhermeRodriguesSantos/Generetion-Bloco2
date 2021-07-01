package com.FarmaciaDaGen.Farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FarmaciaDaGen.Farmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	List<Categoria> findAllByNomeContaining(String nome);

	List<Categoria> findAllByDescricaoContaining(String descricao);
	
	Optional<Categoria> findByNome(String nome);
}
