package com.example.aplicacao.dto;

import java.io.Serializable;

public class AtualizarAssocDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idAprendiz;
	private Integer idInstituicao;
	public Integer getIdAprendiz() {
		return idAprendiz;
	}
	public void setIdAprendiz(Integer idAprendiz) {
		this.idAprendiz = idAprendiz;
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
	public AtualizarAssocDTO() {
		super();
	}
	
	
	

}
