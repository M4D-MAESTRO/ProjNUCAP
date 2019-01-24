package com.example.aplicacao.dominio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;

public class Salvamento {
	private LocalDate data = LocalDate.now();
	private Integer ano = data.getYear();

	private String codAprendiz = ano + "10" + "0";
	private String codInstituicao = ano + "20" + "0";

	private AprendizRepository aprendizRep;
	private InstituicaoRepository instituicaoRep;

	public Integer getCodAprendiz(AprendizRepository aprendizRep, InstituicaoRepository instituicaoRep) {
		this.aprendizRep =  aprendizRep;
		this.instituicaoRep = instituicaoRep;
		Integer id = Integer.parseInt(codAprendiz);
		return id + getDif(true, aprendizRep, instituicaoRep).intValue();
	}

	public Integer getCodInstituicao(AprendizRepository aprendizRep, InstituicaoRepository instituicaoRep) {
		this.aprendizRep = aprendizRep;
		this.instituicaoRep = instituicaoRep;
		Integer id = Integer.parseInt(codInstituicao);
		return id + getDif(false, aprendizRep, instituicaoRep).intValue();
	}

	private Long getDif(boolean select, AprendizRepository aprendizRep, InstituicaoRepository instituicaoRep) {// true = aprendiz; false = instituicao
		this.aprendizRep = aprendizRep;
		this.instituicaoRep = instituicaoRep;
		if (select) {
			return aprendizRep.count();
		} else {
			return instituicaoRep.count();
		}
	}
	
	public Salvamento() {
		
	}

	public Salvamento(AprendizRepository aprendizRep, InstituicaoRepository instituicaoRep) {
		this.aprendizRep = aprendizRep;
		this.instituicaoRep = instituicaoRep;
	}

}
