package com.example.aplicacao.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

public class InstituicaoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Pessoa
	private Integer id;
	@NotEmpty(message = "Preenchimento do nome é obrigatório!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento do telefone é obrigatório!")
	private String telefone;
	
	@NotEmpty(message = "Preenchimento do email é obrigatório!")
	@Email(message = "Email inválido!")
	private String email;
	
	//Instituicao
	@NotEmpty(message = "Preenchimento do email é obrigatório!")
	//@CNPJ
	private String cnpj;
	
	private Integer tipo;
	
	@NotEmpty(message = "Preenchimento da senha é obrigatório!")
	private String senha;
	
	
	//Endereco
	private String endereco;
	private String complemento;
	private String bairro;
	private Integer idCidade;
	private Integer idEstado;
	
	public InstituicaoNewDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
