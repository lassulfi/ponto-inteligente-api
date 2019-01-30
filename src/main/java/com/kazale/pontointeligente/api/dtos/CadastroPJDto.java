package com.kazale.pontointeligente.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPJDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String razaoSocial;
	private String cnpj;

	public CadastroPJDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "O campo [nome] não pode ser vazio")
	@Length(min = 3, max = 200, message = "O campo [nome] deve conter entre 3 e 200 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "O campo [email] não pode ser vazio")
	@Length(min = 5, max = 200, message = "O campo [email] deve conter entre 5 e 200 caracteres")
	@Email(message = "E=mail inválido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "O campo [senha] não pode ser vazio")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@NotEmpty(message = "O campo [CPF] não pode ser vazio")
	@CPF(message = "CPF inválido")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotEmpty(message = "O campo [razão social] não pode ser vazio")
	@Length(min = 5, max = 200, message = "O campo [razão social] deve ter entre 5 e 200 caracteres")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@NotEmpty(message = "O campo [CNPJ] não pode ser vazio")
	@CNPJ(message = "CNPJ inválido")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "CadastroPJDto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
}
