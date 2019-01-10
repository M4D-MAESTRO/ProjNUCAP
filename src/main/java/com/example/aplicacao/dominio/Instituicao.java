package com.example.aplicacao.dominio;

import javax.persistence.Entity;

import com.example.aplicacao.dominio.enums.TipoInstituicao;

@Entity
public class Instituicao extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private Integer tipo;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoInstituicao getTipo() {
		return TipoInstituicao.toEnum(tipo);
	}

	public void setTipo(TipoInstituicao tipo) {
		this.tipo = tipo.getCod();
	}

	public Instituicao(String nome, String telefone, Endereco endereco, String email, String cnpj, TipoInstituicao tipo,
			Integer id) {
		super(nome, telefone, endereco, email, id);
		this.cnpj = cnpj;
		this.tipo = (tipo == null) ? null : tipo.getCod();
	}

	public Instituicao(String nome, String telefone, Endereco endereco, String email, Integer id) {
		super(nome, telefone, endereco, email, id);
	}

	public Instituicao() {

	}

	public Instituicao(Integer id) {
		super(id);
	}

	private String tipoToString() {
		String aux = "";
		
		switch(tipo) {
		
		case 1:
			aux = "escolar";
			break;
			
		case 2:
			aux = "qualificadora";
			break;
			
		case 3:
			aux = "laboral";
			break;
			
		case 4:
			aux = "fiscalizadora";
			break;
		
		}
		return null;
	}

	@Override
	public String toString() {
		return "Instituicão - " + super.getNome() + ". CNPJ: " + cnpj + "\n"
				+ super.toString() + "\n"
				+ "Tipo de instituição " + tipoToString();
	}

}
