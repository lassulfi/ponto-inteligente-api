package com.kazale.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kazale.pontointeligente.api.entities.Funcionario;
import com.kazale.pontointeligente.api.repositories.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private static final String CPF = "242291173474";
	private static final String EMAIL = "email@email.com";
	private static final Long ID = 1L;
	
	@Before
	public void setup() throws Exception{
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Funcionario()));
	}
	
	@Test
	public void testPersistirFuncionario() throws Exception{
		Funcionario funcionario = this.funcionarioService.persistir(new Funcionario());
		
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarPorCpf() throws Exception{
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf(CPF);
		
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarPorEmail() throws Exception{
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail(EMAIL);
		
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarPorId() throws Exception{
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorId(ID);
		
		assertTrue(funcionario.isPresent());
	}
}
