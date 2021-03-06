package com.kazale.pontointeligente.api.dtos;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPFDto {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private Optional<String> valorHora = Optional.empty();
	private Optional<String> qtdeHorasTrabalhoDia = Optional.empty();
	private Optional<String> qtdeHorasAlmoco = Optional.empty();
	private String cnpj;
	
	public CadastroPFDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "O campo 'nome' não pode ser vazio")
	@Length(min = 3, max = 200, message="O campo 'nome' deve ter entre 3 a 200 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "O campo 'email' não pode ser vazio")
	@Length(min = 5, max = 200, message="O campo 'email' deve ter entre 5 a 200 caracteres")
	@Email(message = "E-mail inválido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "O campo 'senha' não pode ser vazio")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@NotEmpty(message = "O campo 'cpf' não pode ser vazio")
	@CPF(message = "CPF inválido")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Optional<String> getValorHora() {
		return valorHora;
	}

	public void setValorHora(Optional<String> valorHora) {
		this.valorHora = valorHora;
	}

	public Optional<String> getQtdeHorasTrabalhoDia() {
		return qtdeHorasTrabalhoDia;
	}

	public void setQtdeHorasTrabalhoDia(Optional<String> qtdeHorasTrabalhoDia) {
		this.qtdeHorasTrabalhoDia = qtdeHorasTrabalhoDia;
	}

	public Optional<String> getQtdeHorasAlmoco() {
		return qtdeHorasAlmoco;
	}

	public void setQtdeHorasAlmoco(Optional<String> qtdeHorasAlmoco) {
		this.qtdeHorasAlmoco = qtdeHorasAlmoco;
	}

	@NotEmpty(message = "O campo 'cnpj' não pode ser vazio")
	@CNPJ(message = "CNPJ inválido")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "CadastroPFDto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdeHorasTrabalhoDia=" + qtdeHorasTrabalhoDia + ", qtdeHorasAlmoco="
				+ qtdeHorasAlmoco + ", cnpj=" + cnpj + "]";
	}
}
