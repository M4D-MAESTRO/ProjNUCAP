package com.example.aplicacao.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Cidade;
import com.example.aplicacao.repositories.CidadeRepository;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findByEstado(Integer estadoId){
		List<Cidade> cidades = repo.findCidades(estadoId);
		
		if(cidades == null) {
			throw new ObjectNotFoundException("Lista de estados não encontrada");
		}
		
		return cidades;
	}

}
