package com.example.aplicacao.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Cidade;
import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.enums.TipoInstituicao;
import com.example.aplicacao.dto.InstituicaoDTO;
import com.example.aplicacao.dto.InstituicaoNewDTO;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.servico.exception.DataIntegrityException;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class InstituicaoService {
	
	@Autowired
	private InstituicaoRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Instituicao find(Integer id) {
		Optional<Instituicao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Instituicao.class.getName()));
	}
	
	public Long getCount() {
		return repo.count();
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
		Instituicao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Instituicao newObj, Instituicao obj) {
		newObj.setNome(obj.getNome());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		newObj.setCnpj(obj.getCnpj());
		
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Instituição relacionada a um Aprendiz");
		};
		
	}
	
	public Page<Instituicao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Page<Instituicao> findInstituicao(Integer page, Integer linesPerPage, String orderBy, String direction, String nome){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findDistinctByNomeContaining(nome,pageRequest);
	}
	
	public Page<Instituicao> findInstituicaoId(Integer page, Integer linesPerPage, String orderBy, String direction, Integer id){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findDistinctByIdContaining(id,pageRequest);
	}
	
	public Page<Instituicao> findInstituicaoByTipo(Integer page, Integer linesPerPage, String orderBy, String direction, Integer tipo){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findDistinctByTipo(tipo,pageRequest);
	}
	
	public Page<Instituicao> findInstituicaoCNPJ(Integer page, Integer linesPerPage, String orderBy, String direction, String cnpj){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		//List<Aprendiz> lista = repo.findListOfName(nome);
		Instituicao exemplo =  new Instituicao();
		exemplo.setCnpj(cnpj);
		return repo.findAll(Example.of(exemplo), pageRequest);
	}
	
	public Instituicao fromDTO(InstituicaoDTO objDTO) {
		return new Instituicao(objDTO.getNome(), objDTO.getTelefone(), null,objDTO.getEmail(), objDTO.getCnpj(), null, objDTO.getId(), null); 
	}
	
	public Instituicao fromDTO(InstituicaoNewDTO objDTO) {
		Instituicao inst = new Instituicao(objDTO.getNome(), objDTO.getTelefone(), null, objDTO.getEmail() , objDTO.getCnpj(), TipoInstituicao.toEnum(objDTO.getTipo()), objDTO.getId(), pe.encode(objDTO.getSenha()));
		Cidade ci = new Cidade(objDTO.getIdCidade(), null, null);
		Endereco end = new Endereco(objDTO.getEndereco(), objDTO.getComplemento(), objDTO.getBairro(), ci, null, inst);
		return inst;
	}
	
	public Instituicao findByEmail(String email) {
		/*UserSS user = UserService.authenticated();
		System.out.println("Meu user no findByEmail: " + user);
		
		if(user == null && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}*/
		System.out.println("Email: " + email);
		Instituicao obj = repo.findByEmail(email);
		//System.out.println("Meu aprendiz: " + obj);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Código de identificação: " /*+ user.getId()*/ + ", Tipo: " + Aprendiz.class.getName());
		}
		
		return obj;
		
	}
	
	
	
	
}
