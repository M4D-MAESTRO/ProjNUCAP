package com.example.aplicacao.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Pessoa;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.PessoaRepository;

@Service
public class AprendizService {
	
	@Autowired
	private AprendizRepository repo;
	
	public Aprendiz find(Integer id) {
		Optional<Aprendiz> obj = repo.findById(id);
		return obj.orElse(null);
	}

	
	public Aprendiz insert(Aprendiz obj) {
		return repo.save(obj);
	}
	
	public Aprendiz update(Aprendiz obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
}
