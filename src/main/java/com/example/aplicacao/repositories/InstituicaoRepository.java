package com.example.aplicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aplicacao.dominio.Instituicao;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer>{
	
	

}
