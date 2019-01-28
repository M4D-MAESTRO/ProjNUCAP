package com.example.aplicacao.dto;

import java.io.Serializable;

import com.example.aplicacao.dominio.Estado;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public EstadoDTO() {
	}
	
	public EstadoDTO(Estado obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	
	
	

}
