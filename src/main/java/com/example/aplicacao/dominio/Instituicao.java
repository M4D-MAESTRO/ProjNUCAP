package com.example.aplicacao.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.aplicacao.dominio.enums.TipoInstituicao;

@Entity
public class Instituicao extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private Integer tipo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "id.instituicao")
	private List<InstituicaoAprendiz> aprendizes = new ArrayList<>();
	
	

	public List<InstituicaoAprendiz> getAprendizes() {
		return aprendizes;
	}

	public void setAprendiz(List<InstituicaoAprendiz> aprendiz) {
		this.aprendizes = aprendiz;
	}

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
			Integer id, String senha) {
		super(nome, telefone, endereco, email, id, senha);
		this.cnpj = cnpj;
		this.tipo = (tipo == null) ? null : tipo.getCod();
	}

	public Instituicao(String nome, String telefone, Endereco endereco, String email, Integer id, String senha) {
		super(nome, telefone, endereco, email, id, senha);
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
