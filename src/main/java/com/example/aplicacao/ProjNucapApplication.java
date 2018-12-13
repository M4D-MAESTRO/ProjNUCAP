package com.example.aplicacao;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.Pessoa;
import com.example.aplicacao.dominio.Salvamento;
import com.example.aplicacao.dominio.enums.TipoInstituicao;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.EnderecoRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.repositories.PessoaRepository;


@SpringBootApplication
@ComponentScan(basePackages={"com.example"})
public class ProjNucapApplication implements CommandLineRunner{
	
	@Autowired
	private AprendizRepository aprendizRep;
	
	@Autowired
	private InstituicaoRepository instituicaoRep;
	
	@Autowired
	private EnderecoRepository enderecoRep;

	public static void main(String[] args) {
		SpringApplication.run(ProjNucapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Long aux;
		LocalDate data = LocalDate.of(1993, 12, 21);
		Endereco end1 = new Endereco("Rua Francisco Paulo, 01", "Fundos", "Mascarenhas", "Rio de Janeiro", "RJ", null);
		Endereco end2 = new Endereco("Rua Hermínio, 6.009", null, null, "Rio das Ostras", "RJ", null);
		enderecoRep.saveAll(Arrays.asList(end1, end2));
		
		aux = instituicaoRep.count(); 
		Instituicao escola = new Instituicao("Centro Educacional Futuro Certo", "21 988554525",end2 , "25.561.654/6321-68",TipoInstituicao.ESCOLA ,Salvamento.getCodInstituicao(aux));
		instituicaoRep.saveAll(Arrays.asList(escola));
		
		aux = instituicaoRep.count(); 
		Instituicao empresaQuali = new Instituicao("Fundação Cursos Oliveira", "21 2141-5522", end2, "44.775/5522-11",TipoInstituicao.QUALIFICADORA,  Salvamento.getCodInstituicao(aux));
		instituicaoRep.saveAll(Arrays.asList(empresaQuali));
		
		aux = instituicaoRep.count(); 
		Instituicao empresa = new Instituicao("Restaurante Sabor Total", "21 95663-2541", end2, "21.252.656/5889-95",TipoInstituicao.LABORAL, Salvamento.getCodInstituicao(aux));
		instituicaoRep.saveAll(Arrays.asList(empresa));
		
		aux = aprendizRep.count();
		Aprendiz apr1 = new Aprendiz("Pedro Augusto de Assis", "(21) 9533-33331", end1, "041.251.478-56", data, "011.225.445-55", "(21) 9999-99999", empresa, escola, empresaQuali,  Salvamento.getCodAprendiz(aux));
		aprendizRep.saveAll(Arrays.asList(apr1));
		
		aux = aprendizRep.count();
		Aprendiz apr2 = new Aprendiz("Wendel Dias Reis", "(21) 9533-33331", end1, "041.251.478-56", data, "011.225.445-55", "(21) 9999-99999",empresaQuali , escola, empresa,  Salvamento.getCodAprendiz(aux));
		aprendizRep.saveAll(Arrays.asList(apr2));

	}
}
