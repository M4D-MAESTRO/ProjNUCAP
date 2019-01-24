package com.example.aplicacao.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.InstituicaoAprendiz;
import com.example.aplicacao.servico.validation.InstituicaoUpdate;

@InstituicaoUpdate
public class InstituicaoCompletaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento do nome é obrigatório!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento do email é obrigatório!")
	@Email
	private String email;
	
	@NotEmpty(message = "Preenchimento do CNPJ é obrigatório!")
	//@CNPJ
	private String cnpj;
	
	@NotEmpty(message = "Preenchimento do telefone é obrigatório!")
	private String telefone;
	
	private List<InstituicaoAprendiz> lista = new ArrayList<>();
	
	public InstituicaoCompletaDTO() {
		
	}
	
	public InstituicaoCompletaDTO(Instituicao obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		cnpj = obj.getCnpj();
		telefone = obj.getTelefone();
		lista = obj.getAprendizes();
		
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<InstituicaoAprendiz> getLista() {
		return lista;
	}

	public void setLista(List<InstituicaoAprendiz> lista) {
		this.lista = lista;
	}	
	
	

}
