package com.example.aplicacao.servico;

import java.util.Arrays;
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
import com.example.aplicacao.dominio.Estado;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.InstituicaoAprendiz;
import com.example.aplicacao.dto.AprendizDTO;
import com.example.aplicacao.dto.AprendizNewDTO;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.CidadeRepository;
import com.example.aplicacao.repositories.EnderecoRepository;
import com.example.aplicacao.repositories.EstadoRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.security.UserSS;
import com.example.aplicacao.servico.exception.AuthorizationException;
import com.example.aplicacao.servico.exception.DataIntegrityException;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class AprendizService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private AprendizRepository repo;

	@Autowired
	private InstituicaoRepository instituicaoRep;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EnderecoRepository endRepo;

	@Autowired
	private CidadeRepository cidaRepo;

	@Autowired
	private EstadoRepository estRepo;

	public Aprendiz find(Integer id) {

		/*
		 * UserSS user = UserService.authenticated();
		 * System.out.println("Meu user no find: " + user); if(user == null ||
		 * !id.equals(user.getId())) { throw new
		 * AuthorizationException("Acesso negado!");
		 * 
		 * }
		 */

		Optional<Aprendiz> obj = repo.findById(id);
		// System.out.println(obj);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aprendiz.class.getName()));
	}

	public Long getCount() {
		return repo.count();
	}

	public Aprendiz findByName(String nome) {
		Aprendiz obj = repo.findByNome(nome);
		return obj;
	}

	public Aprendiz insert(Aprendiz obj) {
		/*try {
			
			
		} catch (UnsupportedOperationException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}*/
		endRepo.saveAndFlush(obj.getEndereco());
		obj = repo.save(obj);
		// System.out.println(obj);
		emailService.sendRegistrationHtmlEmail(obj);
		return obj;
	}

	public List<Aprendiz> findAll() {
		List<Aprendiz> lista = repo.findAll();
		return lista;
	}

	public Aprendiz update(Aprendiz obj) {
		Aprendiz newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Aprendiz newObj, Aprendiz obj) {
		newObj.setNome(obj.getNome());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		newObj.setCpf(obj.getCpf());
		newObj.setDataNascimento(obj.getDataNascimento());

	}

	public void delete(Integer id) {
		find(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar um aprendiz associado com instituições!");
		}
		;

	}

	public Aprendiz findByEmail(String email) {
		/*
		 * UserSS user = UserService.authenticated();
		 * System.out.println("Meu user no findByEmail: " + user);
		 * 
		 * if(user == null && !email.equals(user.getUsername())) { throw new
		 * AuthorizationException("Acesso negado"); }
		 */
		System.out.println("Email: " + email);
		Aprendiz obj = repo.findByEmail(email);
		// System.out.println("Meu aprendiz: " + obj);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Código de identificação: "
					/* + user.getId() */ + ", Tipo: " + Aprendiz.class.getName());
		}

		return obj;

	}

	public Page<Aprendiz> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Page<Aprendiz> findAprendiz(Integer page, Integer linesPerPage, String orderBy, String direction,
			String nome) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		// List<Aprendiz> lista = repo.findListOfName(nome);
		Aprendiz exemplo = new Aprendiz();
		exemplo.setNome(nome);
		return repo.findAll(Example.of(exemplo), pageRequest);
	}

	public Page<Aprendiz> findAprendizCPF(Integer page, Integer linesPerPage, String orderBy, String direction,
			String cpf) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		// List<Aprendiz> lista = repo.findListOfName(nome);
		Aprendiz exemplo = new Aprendiz();
		exemplo.setCpf(cpf);
		return repo.findAll(Example.of(exemplo), pageRequest);
	}

	public Page<Aprendiz> search(String nome, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByNomeContaining(nome, pageRequest);
	}

	private void formataExemplo(String nome) {
		Aprendiz exemplo = new Aprendiz();
		exemplo.setNome(nome);

		// ExampleMatcher ex = ExampleMatcher.matching().
	}

	public Aprendiz fromDTO(AprendizDTO objDTO) {
		return new Aprendiz(objDTO.getNome(), objDTO.getTelefone(), null, objDTO.getEmail(), objDTO.getCpf(),
				objDTO.getDataNascimento(), null, null, null, objDTO.getId(), null);
	}

	public Aprendiz fromDTO(AprendizNewDTO objDTO) {
		Aprendiz apr = new Aprendiz(objDTO.getNome(), objDTO.getTelefone(), null, objDTO.getEmail(), objDTO.getCpf(),
				objDTO.getDataNascimento(), objDTO.getCpfResp(), objDTO.getTelefoneResp(), null, objDTO.getId(),
				pe.encode(objDTO.getSenha()));
		
		Estado es = new Estado(objDTO.getIdEstado(), null);
		Cidade ci = new Cidade(objDTO.getIdCidade(), null, es);
		System.out.println("Estado: " + objDTO.getIdEstado() + " Cidade: " + objDTO.getIdCidade());
		es = estRepo.getOne(objDTO.getIdEstado());
		ci = cidaRepo.getOne(objDTO.getIdCidade());
		Endereco end = new Endereco(objDTO.getEndereco(), objDTO.getComplemento(), objDTO.getBairro(), ci, null, apr);

		/*
		 * Instituicao escola = new Instituicao(null, null, null , null ,null ,
		 * objDTO.getIdEscola()); Instituicao trab = new Instituicao(null, null, null ,
		 * null ,null , objDTO.getIdTrabalho()); Instituicao empQual = new
		 * Instituicao(null, null, null , null ,null , objDTO.getIdEmpresaQuali());
		 */

		/*
		Instituicao escola = instituicaoRep.getOne(objDTO.getIdEscola() == null? 1:objDTO.getIdEscola());
		Instituicao trab = instituicaoRep.getOne(objDTO.getIdTrabalho() == null? 1:objDTO.getIdTrabalho());
		Instituicao empQual = instituicaoRep.getOne(objDTO.getIdEmpresaQuali() == null? 1:objDTO.getIdEmpresaQuali());
		
		apr.setInstituicoes(Arrays.asList(new InstituicaoAprendiz(apr, escola), new InstituicaoAprendiz(apr, trab),
				new InstituicaoAprendiz(apr, empQual)));*/
		
		apr.setEndereco(end);/* tirar aqui */
		return apr;
	}
}
