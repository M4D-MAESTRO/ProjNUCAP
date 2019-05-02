package com.example.aplicacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.InstituicaoAprendiz;

@Repository
public interface InstituicaoAprendizRepository extends JpaRepository<InstituicaoAprendiz, Integer>{
	
	
	InstituicaoAprendiz findByIdAndId(Integer idAprenidz,Integer idInstituicao);
	

}
