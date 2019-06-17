package com.example.aplicacao.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class AtualizarAssocDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idAprendiz;
	private Integer idInstituicao;
	private String percentualFalta;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	
	
	public Integer getIdAprendiz() {
		return idAprendiz;
	}
	public void setIdAprendiz(Integer idAprendiz) {
		this.idAprendiz = idAprendiz;
	}
	public String getPercentualFalta() {
		return percentualFalta;
	}
	public void setPercentualFalta(String percentualFalta) {
		this.percentualFalta = percentualFalta;
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
	public Integer getIdInstituicao() {
		return idInstituicao;
	}
	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	public AtualizarAssocDTO(Integer idAprendiz, Integer idInstituicao) {
		super();
		this.idAprendiz = idAprendiz;
		this.idInstituicao = idInstituicao;
	}
	
	
	
	public AtualizarAssocDTO(Integer idAprendiz, Integer idInstituicao, String percentualFalta, LocalDate dataInicio,
			LocalDate dataTermino) {
		super();
		this.idAprendiz = idAprendiz;
		this.idInstituicao = idInstituicao;
		this.percentualFalta = percentualFalta;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
	public AtualizarAssocDTO() {
		super();
	}
	
	
	

}
