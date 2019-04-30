package com.example.aplicacao.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.servico.validation.AprendizUpdate;

@AprendizUpdate
public class AprendizDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento do nome é obrigatório!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento do telefone é obrigatório!")
	private String telefone;
	
	@NotEmpty(message = "Preenchimento do email é obrigatório!")
	@Email(message = "Email inválido!")
	private String email;
	
	@NotEmpty(message = "Preenchimento do CPF é obrigatório!")
	//@CPF
	private String cpf;
	
	private LocalDate dataNascimento;
	
	
	
	
	public AprendizDTO() {
		
	}
	
	public AprendizDTO(Aprendiz obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		telefone = obj.getTelefone();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
