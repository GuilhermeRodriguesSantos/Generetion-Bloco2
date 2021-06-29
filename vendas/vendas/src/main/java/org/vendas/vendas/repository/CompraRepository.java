package org.vendas.vendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vendas.vendas.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	Optional<Compra> findByNome(String nome);

	public List<Compra> findAllBynomeContaining(String nome);

}
