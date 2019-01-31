package com.kazale.pontointeligente.api.dtos;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class FuncionarioDto {

	private Long id;
	private String nome;
	private String email;
	private Optional<String> senha = Optional.empty();
	private Optional<String> valorHora = Optional.empty();
	private Optional<String> qtdeHorasTrabalhoDia = Optional.empty();
	private Optional<String> qtdeHorasAlmoco = Optional.empty();
	
	public FuncionarioDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "O campo 'nome' não pode ser vazio")
	@Length(min = 3, max = 200, message = "O campo 'nome' deve conter entre 3 a 20 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "O campo 'email' não pode ser vazio")
	@Length(min = 5, max = 200, message = "O campo 'email' deve conter entre 5 a 200 caracteres")
	@Email(message = "E-mail invalido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Optional<String> getSenha() {
		return senha;
	}

	public void setSenha(Optional<String> senha) {
		this.senha = senha;
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

	@Override
	public String toString() {
		return "FuncionarioDto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", valorHora="
				+ valorHora + ", qtdeHorasTrabalhoDia=" + qtdeHorasTrabalhoDia + ", qtdeHorasAlmoco=" + qtdeHorasAlmoco
				+ "]";
	}
}
