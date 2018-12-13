package com.example.aplicacao.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.servico.exception.DataIntegrityException;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class AprendizService {
	
	@Autowired
	private AprendizRepository repo;
	
	public Aprendiz find(Integer id) {
		Optional<Aprendiz> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aprendiz.class.getName()));
	}
	
	/*public Aprendiz findByName(String nome) {
		Optional<Aprendiz> obj = repo.findByName(nome);
		return obj.orElse(null);
	}*/
	
	public List<Aprendiz> findAll(){
		List<Aprendiz> lista = repo.findAll();
		return lista;
	}

	
	public Aprendiz insert(Aprendiz obj) {
		return repo.save(obj);
	}
	
	public Aprendiz update(Aprendiz obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos cadastrados");
		};
		
	}
}
