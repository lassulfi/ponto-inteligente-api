package com.kazale.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kazale.pontointeligente.api.entities.Lancamento;
import com.kazale.pontointeligente.api.repositories.LancamentoRepository;
import com.kazale.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Cacheable("lancamentoPorId")
	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando um lancamento com id", id);
		return this.lancamentoRepository.findById(id);
	}

	@Override
	public Page<Lancamento> buscarFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando uma lista de lancamentos com paginacao para funcionario id {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@CachePut("lancamentoPorId")
	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lancamento {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo o lancamento com id {}", id);
		this.lancamentoRepository.deleteById(id);
	}

}