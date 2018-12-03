package com.example.aplicacao.dominio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String telefone;
	@OneToOne
	private Endereco endereco;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Pessoa(String nome, String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public Pessoa() {
		super();
	}
	
	
	

}
