package com.example.aplicacao.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.example.aplicacao.dominio.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	
	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String senha;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Endereco endereco;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Pessoa(String nome, String telefone, Endereco endereco, String email, Integer id, String senha) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		//this.endereco = endereco;
		this.email = email;
		this.id = id;
		this.senha = senha;
		addPerfil(Perfil.USUARIO);
	}
	
	
	
	public Pessoa() {
		super();
		addPerfil(Perfil.USUARIO);
	}
	
	public Pessoa(Integer id) {
		super();
		this.id = id;		
	}
	
	@Override
	public String toString() {
		return "Código de Identificação: " + id + "\n"
				+ "Telefone:" + telefone + "\n"
				+ "Email: " + email + "\n"
				+ endereco.toString();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	

}
