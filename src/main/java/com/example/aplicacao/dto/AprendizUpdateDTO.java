package com.example.aplicacao.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.servico.validation.AprendizUpdate;

@AprendizUpdate
public class AprendizUpdateDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimentodo nome é obrigatório!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento do email é obrigatório!")
	@Email(message = "Email inválido!")
	private String email;	
	
	public AprendizUpdateDTO() {
		
	}
	
	public AprendizUpdateDTO(Aprendiz obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
