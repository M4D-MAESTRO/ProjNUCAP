package com.example.aplicacao.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.servico.exception.DataIntegrityException;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class InstituicaoService {
	
	@Autowired
	private InstituicaoRepository repo;
	
	public Instituicao find(Integer id) {
		Optional<Instituicao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Instituicao.class.getName()));
	}
	
	public Instituicao findByType(int tipo) {
		List<Instituicao> lista = repo.findAll();
		Instituicao obj = null;
		for(Instituicao x: lista) {
			if(x.getTipo().getCod() == tipo) {
				obj = x;
			}
		}
		
		return obj;
	}
	
	/*public Instituicao findByName(String nome) {
		Optional<Instituicao> obj = repo.findByName(nome);
		return obj.orElse(null);
	}*/
	
	public List<Instituicao> findAll(){
		List<Instituicao> lista = repo.findAll();
		return lista;
	}

	
	public Instituicao insert(Instituicao obj) {
		return repo.save(obj);
	}
	
	public Instituicao update(Instituicao obj) {
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
