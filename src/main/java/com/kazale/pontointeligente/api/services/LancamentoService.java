package com.kazale.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kazale.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	/**
	 * Retorna uma lista de lancamentos por ID
	 * 
	 * @param id
	 * @return
	 */
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * Retorna um lancamento por ID. O retorno é paginado
	 * 
	 * @param id
	 * @param pageRequest
	 * @return
	 */
	Page<Lancamento> buscarFuncionarioId(Long id, PageRequest pageRequest);
	
	/**
	 * Persiste um lancamento na base de dados
	 * @param lancamento
	 * @return
	 */
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remove um lancamento por id
	 * @param id
	 */
	void remover(Long id);
}
