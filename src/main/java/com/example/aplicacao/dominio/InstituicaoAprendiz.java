package com.example.aplicacao.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstituicaoAprendiz implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private InstituicaoAprendizPK id = new InstituicaoAprendizPK();
	
	private LocalDate dataDeInicio;
	private LocalDate dataDeTermino;
	private String percentualDeFalta;
	
	public InstituicaoAprendiz() {
		
	}
	
	public InstituicaoAprendiz(Aprendiz aprendiz, Instituicao instituicao) {
		id.setAprendiz(aprendiz);
		id.setInstituicao(instituicao);
	}
	


	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public LocalDate getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(LocalDate dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	public String getPercentualDeFalta() {
		return percentualDeFalta;
	}

	public void setPercentualDeFalta(String percentualDeFalta) {
		this.percentualDeFalta = percentualDeFalta;
	}
	
	
	public String getInstituicao() {
		return id.getInstituicao().getNome() + " - " + id.getInstituicao().getTipo().getDescricao();
	}
	
	public String getAprendiz() {
		return id.getAprendiz().getNome();
	}
	
	public InstituicaoAprendizPK getId() {
		return id;
	}

	public void setId(InstituicaoAprendizPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		InstituicaoAprendiz other = (InstituicaoAprendiz) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aprendiz: " + id.getAprendiz().getNome() + "\n" + id.getInstituicao().getNome();
	}

	
	

}
