package com.example.aplicacao.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.aplicacao.dominio.Aprendiz;

public class AprendizDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String telefone;
	
	private String cpf;
	private LocalDate dataNascimento;
	
	
	public AprendizDTO() {
		
	}
	
	public AprendizDTO(Aprendiz obj) {
		id = obj.getId();
		nome = obj.getNome();
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
	
	
}
