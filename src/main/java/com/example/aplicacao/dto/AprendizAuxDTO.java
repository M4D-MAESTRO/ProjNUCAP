package com.example.aplicacao.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.aplicacao.dominio.Instituicao;

public class AprendizAuxDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private String percentualFalta;
	private String nome;

	public AprendizAuxDTO() {

	}

	public AprendizAuxDTO(Instituicao obj, int index) {
		this.dataInicio = obj.getAprendizes().get(index).getDataDeInicio();
		this.dataTermino = obj.getAprendizes().get(index).getDataDeTermino();
		this.percentualFalta = obj.getAprendizes().get(index).getPercentualDeFalta();
		this.nome = obj.getAprendizes().get(index).getAprendiz();
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
