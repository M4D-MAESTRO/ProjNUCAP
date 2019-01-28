package com.example.aplicacao.dto;

import java.io.Serializable;

import com.example.aplicacao.dominio.Cidade;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CidadeDTO() {
		
	}
	
	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	

}
