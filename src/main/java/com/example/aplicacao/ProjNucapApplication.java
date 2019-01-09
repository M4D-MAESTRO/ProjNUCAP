package com.example.aplicacao;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Cidade;
import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Estado;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.Salvamento;
import com.example.aplicacao.dominio.enums.TipoInstituicao;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.CidadeRepository;
import com.example.aplicacao.repositories.EnderecoRepository;
import com.example.aplicacao.repositories.EstadoRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;


@SpringBootApplication
@ComponentScan(basePackages={"com.example"})
public class ProjNucapApplication implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjNucapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		

	}
}
