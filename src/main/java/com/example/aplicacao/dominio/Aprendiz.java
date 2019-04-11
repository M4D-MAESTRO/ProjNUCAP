package com.example.aplicacao.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
//@PrimaryKeyJoinColumn(name="id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Aprendiz extends Pessoa {

	private static final long serialVersionUID = 1L;
	private String cpf;
	private LocalDate dataNascimento;

	private String cpfResp;
	private String telefoneResp;
	
	//private Instituicao trabalho;
	//private Instituicao escola;
	//private Instituicao empresaQuali;
 
	/*
	 * //@OneToOne(cascade = {CascadeType.ALL})
	 * 
	 * @OneToMany(mappedBy = "instituicao") private Instituicao trabalho;
	 * 
	 * @OneToMany(mappedBy = "instituicao") private Instituicao escola;
	 * 
	 * @OneToMany(mappedBy = "instituicao") private Instituicao empresaQuali;
	 */

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "id.aprendiz")
	private List<InstituicaoAprendiz> instituicoes = new ArrayList<>();

	
	public List<InstituicaoAprendiz> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<InstituicaoAprendiz> instituicoes) {
		this.instituicoes = instituicoes;
		/*trabalho = this.instituicoes.get(0).getId().getInstituicao();
		escola = this.instituicoes.get(1).getId().getInstituicao();
		empresaQuali = this.instituicoes.get(2).getId().getInstituicao();*/
		
	}
	
	
/*
	public Instituicao getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Instituicao trabalho) {
		this.trabalho = trabalho;
	}

	public Instituicao getEscola() {
		return escola;
	}

	public void setEscola(Instituicao escola) {
		this.escola = escola;
	}

	public Instituicao getEmpresaQuali() {
		return empresaQuali;
	}

	public void setEmpresaQuali(Instituicao empresaQuali) {
		this.empresaQuali = empresaQuali;
	}*/

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpfResp() {
		return cpfResp;
	}

	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}

	public String getTelefoneResp() {
		return telefoneResp;
	}

	public void setTelefoneResp(String telefoneResp) {
		this.telefoneResp = telefoneResp;
	}


	public Aprendiz(String nome, String telefone, Endereco endereco, String email, String cpf, LocalDate dataNascimento,
			String cpfResp, String telefoneResp, List<InstituicaoAprendiz> instituicoes, Integer id, String senha) {
		super(nome, telefone, endereco, email, id, senha);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cpfResp = cpfResp;
		this.telefoneResp = telefoneResp;
		this.instituicoes = instituicoes;
		super.setEmail(email);
	}
	
	public Aprendiz(String nome, String telefone, Endereco endereco, String email, String cpf, LocalDate dataNascimento,
			String cpfResp, String telefoneResp,  Integer id, String senha) {
		super(nome, telefone, endereco, email, id, senha);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cpfResp = cpfResp;
		this.telefoneResp = telefoneResp;
		super.setEmail(email);
	}

	public Aprendiz(String nome, String telefone, Endereco endereco, String email, Integer id, String senha) {
		super(nome, telefone, endereco, email, id, senha);
	}

	public Aprendiz() {

	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Aprendiz - " + super.getNome() + "\n" + super.toString() + "\n" + "CPF: " + cpf
				+ ", data de nascimento " + dataNascimento.format(dtf) + "\n" + "CPF do Responsável: " + cpfResp
				+ ", telefone do responsável " + telefoneResp + "\n\n" + "Instituição de trabalho: "
				/*+ instituicao.toString() .getId().getInstituicao().getNome() + "\n" + "Instituição de Escola: "
				+ escola.getId().getInstituicao().getNome() + "\n" + "Instituição Qualificadora: "
				+ empresaQuali.getId().getInstituicao().getNome()*/;
	}
	
	public Instituicao getObjectReference(HashSet<Instituicao> set, Instituicao obj) {
	    if (set.contains(obj)) {
	        for (Instituicao o : set) {
	            if (obj.equals(o))
	                return o;
	        }
	    }
	    return null;
	}

}
