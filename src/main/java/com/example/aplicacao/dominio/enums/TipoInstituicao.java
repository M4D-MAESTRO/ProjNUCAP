package com.example.aplicacao.dominio.enums;

public enum TipoInstituicao {
	
	ESCOLAR(1, "Escola"),
	QUALIFICADORA(2, "Qualificadora"),
	LABORAL(3, "Laboral"),
	FISCALIZADOR(4, "Ficalizadora");
	
	private int cod;
	private String descricao;
	
	private TipoInstituicao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoInstituicao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoInstituicao x: TipoInstituicao.values()) {
			
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
