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
import com.example.aplicacao.dominio.Pessoa;
import com.example.aplicacao.repositories.PessoaRepository;


@SpringBootApplication
@ComponentScan(basePackages={"com.example"})
public class ProjNucapApplication implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRep;

	public static void main(String[] args) {
		SpringApplication.run(ProjNucapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate data = LocalDate.of(1993, 12, 21);
		Endereco end1 = new Endereco("Rua Francisco Paulo, 01", "Fundos", "Mascarenhas", "Rio de Janeiro", "RJ", null);
		Aprendiz apr1 = new Aprendiz("Pedro Augusto de Assis", "(21) 9533-33331", end1, "041.251.478-56", data, "011.225.445-55", "(21) 9999-99999", null, null, null, null);
		
		pessoaRep.saveAll(Arrays.asList(apr1));
	}
}
