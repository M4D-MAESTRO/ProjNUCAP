package com.example.aplicacao.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Estado;
import com.example.aplicacao.repositories.EstadoRepository;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll(){
		List<Estado> estados = repo.findAllByOrderByNome();
		if(estados == null) {
			throw new ObjectNotFoundException("Lista de estados não encontrada");
		}
		
		return estados;
	}

}
