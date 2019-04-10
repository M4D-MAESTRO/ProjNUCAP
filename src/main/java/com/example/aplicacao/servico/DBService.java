package com.example.aplicacao.servico;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Cidade;
import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Estado;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.InstituicaoAprendiz;
import com.example.aplicacao.dominio.Salvamento;
import com.example.aplicacao.dominio.enums.Perfil;
import com.example.aplicacao.dominio.enums.TipoInstituicao;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.CidadeRepository;
import com.example.aplicacao.repositories.EnderecoRepository;
import com.example.aplicacao.repositories.EstadoRepository;
import com.example.aplicacao.repositories.InstituicaoAprendizRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;

@Service
public class DBService {

	@Autowired
	private AprendizRepository aprendizRep;

	@Autowired
	private InstituicaoRepository instituicaoRep;

	@Autowired
	private EnderecoRepository enderecoRep;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private InstituicaoAprendizRepository instAprRepo;

	@Autowired
	private BCryptPasswordEncoder pe;
	
	private Salvamento sav = new Salvamento();

	public void instantiateDataBase() {
		
		// Instancia de Estado e Cidade

		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Rio De Janeiro");
		Estado est3 = new Estado(null, "Espírito Santo");

		Cidade c1 = new Cidade(null, "São Paulo", est1);
		Cidade c2 = new Cidade(null, "Rio De Janeiro", est2);
		Cidade c3 = new Cidade(null, "Campo Grande", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Long aux;
		LocalDate data = LocalDate.of(1993, 12, 21);
		Endereco end1 = new Endereco("Rua Francisco Paulo, 01", "Fundos", "Mascarenhas", c2, null);
		Endereco end2 = new Endereco("Rua Hermínio, 6.009", "Casa 3", "Tijuca", c3, null);
		enderecoRep.saveAll(Arrays.asList(end1, end2));


		Instituicao escola = new Instituicao("Centro Educacional Futuro Certo", "(21) 988554525", end2,
				"centroedu@gmail.com", "25.561.654/6321-68", TipoInstituicao.ESCOLAR, null,
				pe.encode("senha1"));
		escola.addPerfil(Perfil.ADMIN);


		Instituicao empresaQuali = new Instituicao("Fundação Cursos Oliveira", "(21) 2141-5522", end2,
				"fundaoliveira@gmail.com", "44.775/5522-11", TipoInstituicao.QUALIFICADORA, null,
				pe.encode("senha2"));
		empresaQuali.addPerfil(Perfil.ADMIN);
	


		Instituicao empresa = new Instituicao("Restaurante Sabor Total", "(21) 95663-2541", end2,
				"sabortotal@gmail.com", "21.252.656/5889-95", TipoInstituicao.LABORAL, null,
				pe.encode("senha3"));
		empresa.addPerfil(Perfil.ADMIN);
		
		Instituicao gambiarra = new Instituicao("Sem instituição selecionada", "", null,
				"", "", TipoInstituicao.ESCOLAR, 0,
				pe.encode("senha1"));
		gambiarra.addPerfil(Perfil.ADMIN);
		instituicaoRep.saveAll(Arrays.asList(gambiarra));
		
		instituicaoRep.saveAll(Arrays.asList(escola, empresaQuali, empresa));
		
		
		  Aprendiz apr1 = new Aprendiz("Pedro Augusto de Assis", "(21) 9533-33331", end1,"luishccorrea@gmail.com" , "041.251.478-56", data, "011.225.445-55", "(21) 9999-99999", null , null, pe.encode("senha4"));
		  apr1.addPerfil(Perfil.ADMIN);
		  
		  Aprendiz apr2 = new Aprendiz("Wendel Dias Reis", "(21) 9533-33331", end1,"diasreis@gmail.com" , "041.251.478-56", data, "011.225.445-55", "(21) 9999-99999", null , null, pe.encode("senha5"));
		  apr2.addPerfil(Perfil.ADMIN);
		  aprendizRep.saveAll(Arrays.asList(apr1, apr2));
		  
		  
		  InstituicaoAprendiz instApr1 = new InstituicaoAprendiz(apr1, empresa);
		  InstituicaoAprendiz instApr2 = new InstituicaoAprendiz(apr1, escola);
		  InstituicaoAprendiz instApr3 = new InstituicaoAprendiz(apr1, empresaQuali);
		  
		  InstituicaoAprendiz instApr4 = new InstituicaoAprendiz(apr2, empresa);
		  InstituicaoAprendiz instApr5 = new InstituicaoAprendiz(apr2, escola);
		  InstituicaoAprendiz instApr6 = new InstituicaoAprendiz(apr2, empresaQuali);
		  
		  instAprRepo.saveAll(Arrays.asList(instApr1, instApr2, instApr3, instApr4, instApr5 ,instApr6));
		  
		  /*		  
		  empresa.setAprendiz(Arrays.asList(instApr1, instApr4));
		  escola.setAprendiz(Arrays.asList(instApr2, instApr5));
		  empresaQuali.setAprendiz(Arrays.asList(instApr3, instApr6));
		  instituicaoRep.saveAll(Arrays.asList(escola, empresaQuali, empresa));
		  
		  apr1.setInstituicoes(Arrays.asList(instApr1, instApr2, instApr3));
		  apr2.setInstituicoes(Arrays.asList(instApr4, instApr5, instApr6));
		  aprendizRep.saveAll(Arrays.asList(apr1, apr2));*/
		  //apr1.setEscola(escola); instituicaoRep.saveAll(Arrays.asList(empresa, escola, empresaQuali));
		 

	}

}
