package org.vendas.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vendas.vendas.model.Compra;
import org.vendas.vendas.model.dtos.CompraDTO;
import org.vendas.vendas.repository.CompraRepository;

@Service
public class CompraServices {
	
	@Autowired
	private CompraRepository repository;
	
	
	/**
	 * 
	 * @param cadastrando
	 * @return um produto existente ou um novo produto
	 * @since 1.0
	 * @author Guilherme
	 */
	public Optional<Object> Cadastar (Compra cadastrando){
		return repository.findByNome(cadastrando.getNome()).map(novo -> {
			return Optional.empty();
		}).orElseGet(() ->{
			return Optional.ofNullable(repository.save(cadastrando));
		});
	}
	
	public Optional<Compra> atualizar(long id, CompraDTO compraAtualizar){
		return repository.findById(id).map(novaCompra ->{
			novaCompra.setNome(compraAtualizar.getNome());
			novaCompra.setPreco(compraAtualizar.getPreco());
			return Optional.ofNullable(repository.save(novaCompra));
		}).orElseGet(() ->{
			return Optional.empty();
			});
	}
	
}
