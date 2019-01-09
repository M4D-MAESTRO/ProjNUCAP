package com.example.aplicacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aplicacao.dominio.Aprendiz;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Integer>{
	
	/*@Query("SELECT p from Pessoa p where p.nome like '?%'")
	Optional<Aprendiz> findByName(String nome);*/
	
	@Transactional(readOnly = true)
	Aprendiz findByEmail(String email);
	
	@Transactional(readOnly = true)
	Aprendiz findByNome(String nome);
	
	/*@Query("SELECT a FROM Aprendiz a WHERE LOWER(a.nome) LIKE LOWER(?nome%)")
	public List<Aprendiz> findListOfName(String nome, Pageable pageable);*/
	
	/*@Query("SELECT DISTINCT obj FROM Aprendiz obj WHERE obj.nome like %:nome%")
	Page<Aprendiz> search(@Param("nome") String nome, Pageable pageRequest);*/
	
	
	Page<Aprendiz> findDistinctByNomeContaining(String nome, Pageable pageRequest);

}
