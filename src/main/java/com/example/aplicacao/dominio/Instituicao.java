package com.example.aplicacao.dominio;

import javax.persistence.Entity;

import com.example.aplicacao.dominio.enums.TipoInstituicao;

@Entity
public class Instituicao extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private Integer tipo;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoInstituicao getTipo() {
		return TipoInstituicao.toEnum(tipo);
	}

	public void setTipo(TipoInstituicao tipo) {
		this.tipo = tipo.getCod();
	}
	
	public Instituicao(String nome, String telefone, Endereco endereco, String cnpj,TipoInstituicao tipo, Integer id) {
		super(nome, telefone, endereco,id);
		this.cnpj = cnpj;
		this.tipo = tipo.getCod();
	}

	public Instituicao(String nome, String telefone, Endereco endereco, Integer id) {
		super(nome, telefone, endereco, id);
	}
	
	public Instituicao() {
		
	}

}
