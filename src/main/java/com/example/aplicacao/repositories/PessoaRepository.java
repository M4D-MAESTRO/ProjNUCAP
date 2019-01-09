package com.example.aplicacao.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	@Transactional(readOnly = true)
	Pessoa findByEmail(String email);
	

}
