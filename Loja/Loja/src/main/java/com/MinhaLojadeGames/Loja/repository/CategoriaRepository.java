package com.MinhaLojadeGames.Loja.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MinhaLojadeGames.Loja.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findAllByTipoContaining(String tipo);
	Optional<Categoria> findByTipo(String tipo);
	Optional<Categoria> findByIdCategoria(long idCategoria);
}
