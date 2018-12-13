package com.example.aplicacao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Pessoa;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Integer>{
	
	/*@Query("SELECT a.id, a.nome, a.telefone, a.endereco_id, a.cpf, a.cpf_resp, a.data_nascimento, a.telefone_resp from aprendiz a")
	Optional<Aprendiz> findByName(String nome);*/

}
