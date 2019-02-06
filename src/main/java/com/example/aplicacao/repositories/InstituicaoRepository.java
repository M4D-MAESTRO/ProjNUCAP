package com.example.aplicacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.Pessoa;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer>{
	
	@Transactional(readOnly = true)
	Instituicao findByEmail(String email);
	
	Page<Instituicao>  findDistinctByNomeContaining(String nome, Pageable pageRequest);
	Page<Instituicao>  findDistinctByIdContaining(Integer id, Pageable pageRequest);
	Page<Instituicao>  findDistinctByTipo(Integer tipo, Pageable pageRequest);
	

}
