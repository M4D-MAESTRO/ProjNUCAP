package com.example.aplicacao.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InstituicaoAprendizPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
 	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_aprendiz")
	private Aprendiz aprendiz;
 	
 	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_instituicao", nullable=false)
	private Instituicao instituicao;

	public Aprendiz getAprendiz() {
		return aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aprendiz == null) ? 0 : aprendiz.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstituicaoAprendizPK other = (InstituicaoAprendizPK) obj;
		if (aprendiz == null) {
			if (other.aprendiz != null)
				return false;
		} else if (!aprendiz.equals(other.aprendiz))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		return true;
	}
 	
	
 	
	
	

}
