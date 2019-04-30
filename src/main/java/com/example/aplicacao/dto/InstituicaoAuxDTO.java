package com.example.aplicacao.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Instituicao;

public class InstituicaoAuxDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private String percentualFalta;
	private String nome;

	public InstituicaoAuxDTO() {

	}

	public InstituicaoAuxDTO(Aprendiz obj, int index) {
		this.dataInicio = obj.getInstituicoes().get(index).getDataDeInicio();
		this.dataTermino = obj.getInstituicoes().get(index).getDataDeTermino();
		this.percentualFalta = obj.getInstituicoes().get(index).getPercentualDeFalta();
		this.nome = obj.getInstituicoes().get(index).getInstituicao();
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getPercentualFalta() {
		return percentualFalta;
	}

	public void setPercentualFalta(String percentualFalta) {
		this.percentualFalta = percentualFalta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
