package com.example.aplicacao.dominio;

import java.time.LocalDate;

public class Aprendiz extends Pessoa{
	
	private String cpf;
	private LocalDate dataNascimento;
	
	private String cpfResp;
	private String telefoneResp;
	
	private Instituicao trabalho;
	private Instituicao escola;
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
	public Aprendiz(String nome, String telefone, Endereco endereco, String cpf, LocalDate dataNascimento,
			String cpfResp, String telefoneResp, Instituicao trabalho, Instituicao escola, Instituicao empresaQuali) {
		super(nome, telefone, endereco);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cpfResp = cpfResp;
		this.telefoneResp = telefoneResp;
		this.trabalho = trabalho;
		this.escola = escola;
		this.empresaQuali = empresaQuali;
	}
	
	
	
	

}
