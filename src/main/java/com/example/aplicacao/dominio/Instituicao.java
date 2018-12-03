package com.example.aplicacao.dominio;

import javax.persistence.Entity;

@Entity
public class Instituicao extends Pessoa{
	
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Instituicao(String nome, String telefone, Endereco endereco, String cnpj, Integer id) {
		super(nome, telefone, endereco,id);
		this.cnpj = cnpj;
	}

	public Instituicao(String nome, String telefone, Endereco endereco, Integer id) {
		super(nome, telefone, endereco, id);
	}
	
	public Instituicao() {
		
	}

}
