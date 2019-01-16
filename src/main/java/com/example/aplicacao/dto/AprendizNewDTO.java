package com.example.aplicacao.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

public class AprendizNewDTO implements Serializable{

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
	
	//Aprendiz
	@NotEmpty(message = "Preenchimento do CPF é obrigatório!")
	//@CPF
	private String cpf;
	
	private LocalDate dataNascimento;	
	
	@NotEmpty(message = "Preenchimento do CPF do responsável é obrigatório!")
	//@CPF
	private String cpfResp;
	
	@NotEmpty(message = "Preenchimento do número telefónico do responsável é obrigatório!")
	private String telefoneResp;
	
	private String senha;
	
	//Endereco
	private String endereco;
	private String complemento;
	private String bairro;
	private Integer idCidade;
	private Integer idEstado;
	
	//Instituicoes
	private Integer idTrabalho;
	private Integer idEscola;
	private Integer idEmpresaQuali;
	
	public AprendizNewDTO() {
		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpfResp() {
		return cpfResp;
	}

	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}

	public String getTelefoneResp() {
		return telefoneResp;
	}

	public void setTelefoneResp(String telefoneResp) {
		this.telefoneResp = telefoneResp;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdTrabalho() {
		return idTrabalho;
	}

	public void setIdTrabalho(Integer idTrabalho) {
		this.idTrabalho = idTrabalho;
	}

	public Integer getIdEscola() {
		return idEscola;
	}

	public void setIdEscola(Integer idEscola) {
		this.idEscola = idEscola;
	}

	public Integer getIdEmpresaQuali() {
		return idEmpresaQuali;
	}

	public void setIdEmpresaQuali(Integer idEmpresaQuali) {
		this.idEmpresaQuali = idEmpresaQuali;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
