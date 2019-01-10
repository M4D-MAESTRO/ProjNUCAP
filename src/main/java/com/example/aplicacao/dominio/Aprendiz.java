package com.example.aplicacao.dominio;


import java.time.LocalDate;

import javax.persistence.*;

@Entity
//@PrimaryKeyJoinColumn(name="id")
@Inheritance(strategy=InheritanceType.JOINED)
public class Aprendiz extends Pessoa {

	private static final long serialVersionUID = 1L;
	private String cpf;
	private LocalDate dataNascimento;
	
	private String cpfResp;
	private String telefoneResp;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Instituicao trabalho;
	@OneToOne(cascade = {CascadeType.ALL})
	private Instituicao escola;
	@OneToOne(cascade = {CascadeType.ALL})
	private Instituicao empresaQuali;
	
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
	public String getCpfResp() {
		return cpfResp;
	}
	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}
	public String getTelefoneResp() {
		return telefoneResp;
	}
	public void setTelefoneResp(String telefoneResp) {
		this.telefoneResp = telefoneResp;
	}
	public Instituicao getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Instituicao trabalho) {
		this.trabalho = trabalho;
	}
	public Instituicao getEscola() {
		return escola;
	}
	public void setEscola(Instituicao escola) {
		this.escola = escola;
	}
	public Instituicao getEmpresaQuali() {
		return empresaQuali;
	}
	public void setEmpresaQuali(Instituicao empresaQuali) {
		this.empresaQuali = empresaQuali;
	}
	public Aprendiz(String nome, String telefone, Endereco endereco, String email, String cpf, LocalDate dataNascimento,
			String cpfResp, String telefoneResp, Instituicao trabalho, Instituicao escola, Instituicao empresaQuali, Integer id) {
		super(nome, telefone, endereco, email, id);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cpfResp = cpfResp;
		this.telefoneResp = telefoneResp;
		this.trabalho = trabalho;
		this.escola = escola;
		this.empresaQuali = empresaQuali;
		super.setEmail(email);
	}
	public Aprendiz(String nome, String telefone, Endereco endereco, String email, Integer id) {
		super(nome, telefone, endereco, email, id);
	}

	public Aprendiz() {
		
	}
	
	@Override
	public String toString() {
		return "Aprendiz - " + super.getNome() + "\n"
				+ super.toString() + "\n"
				+ "CPF: " + cpf + ", data de nascimento " + dataNascimento + "\n"
				+ "CPF do Responsável: " + cpfResp + ", telefone do responsável " + telefoneResp + "\n\n"
				+ "Instituição de trabalho: " + trabalho.getNome() + "\n"
				+ "Instituição de Escola: " + escola.getNome() + "\n"
				+ "Instituição Qualificadora: " + empresaQuali.getNome();
	}

			
	
}
