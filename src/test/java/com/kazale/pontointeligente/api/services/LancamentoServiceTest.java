package com.kazale.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kazale.pontointeligente.api.entities.Lancamento;
import com.kazale.pontointeligente.api.repositories.LancamentoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {

	@MockBean
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private LancamentoService lancamentoService;

	private static final Long FUNCIONARIO_ID = 1L;
	private static final Long ID = 1L;

	@Before
	public void setup() throws Exception {
		BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());
		BDDMockito.given(this.lancamentoRepository.findById(Mockito.anyLong()))
				.willReturn(Optional.of(new Lancamento()));
		BDDMockito
				.given(this.lancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
				.willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
	}
	
	@Test
	public void testBuscarLacamentoPorFuncionarioPorId() {
		Page<Lancamento> lancamentos = this.lancamentoService.buscarFuncionarioId(FUNCIONARIO_ID, PageRequest.of(0, 10));
	
		assertNotNull(lancamentos);
	}
	
	@Test
	public void testBuscarLancamentoPorId() {
		Optional<Lancamento> lancamento = this.lancamentoService.buscarPorId(ID);
		
		assertTrue(lancamento.isPresent());
	}
	
	@Test
	public void testPersistirLancamento() {
		Lancamento lancamento = this.lancamentoService.persistir(new Lancamento());
		
		assertNotNull(lancamento);
	}
	
	@Test
	public void testRemoverLancamento() {
		BDDMockito.given(this.lancamentoRepository.findById(ID)).willReturn(null);
		
		this.lancamentoService.remover(ID);
		
		Optional<Lancamento> lancamento = this.lancamentoService.buscarPorId(ID);
		
		assertNull(lancamento);
	}
}
