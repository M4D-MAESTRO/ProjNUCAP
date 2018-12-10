package com.example.aplicacao.dominio;

import java.time.LocalDate;



public abstract class Salvamento {
	private static LocalDate data = LocalDate.now();
	private static Integer ano = data.getYear();
	
	private static String codAprendiz = ano + "10";
	private static String codInstituicao = ano + "20";
	
	public static Integer getCodAprendiz(Long dif) {
		Integer id = Integer.parseInt(codAprendiz + dif);		
		return id;
	}
	
	public static Integer getCodInstituicao(Long dif) {
		Integer id = Integer.parseInt(codInstituicao + dif);		
		return id;
	}

}
