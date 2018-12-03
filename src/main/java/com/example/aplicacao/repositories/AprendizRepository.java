package com.example.aplicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Pessoa;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Integer>{
	
	

}
