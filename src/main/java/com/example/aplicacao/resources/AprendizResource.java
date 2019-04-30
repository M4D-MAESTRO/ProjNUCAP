package com.example.aplicacao.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dto.AprendizDTO;
import com.example.aplicacao.dto.AprendizNewDTO;
import com.example.aplicacao.dto.ListaAprendizesDTO;
import com.example.aplicacao.dto.ListaInstituicoesDTO;
import com.example.aplicacao.resources.utils.URL;
import com.example.aplicacao.servico.AprendizService;

@RestController
@RequestMapping(value = "/aprendiz")
public class AprendizResource {
	
	@Autowired 
	private AprendizService servico;
	
	@RequestMapping(value="/{id}",  method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Aprendiz obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}/instituicoes",method = RequestMethod.GET)
	public ResponseEntity<?> findAlunos(@PathVariable Integer id){
		Aprendiz obj = servico.find(id);
		ListaInstituicoesDTO listaDTO = new ListaInstituicoesDTO(obj);
		return ResponseEntity.ok().body(listaDTO.getLista());
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="value") String email){
		Aprendiz apr = servico.findByEmail(email);
		return ResponseEntity.ok().body(apr);
	}
	/*
	@RequestMapping(value="/{nome}", params="aprendizNome", method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="aprendizNome") String nome) {
		Aprendiz obj = servico.findByName(nome);
		return ResponseEntity.ok().body(obj);
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AprendizDTO>> getAll() {
		List<Aprendiz> lista = servico.findAll();
		List<AprendizDTO> listaDTO = lista.stream().map(obj -> new AprendizDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AprendizDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		Page<Aprendiz> lista = servico.findPage(page, linesPerPage, orderBy, direction);
		Page<AprendizDTO> listaDTO = lista.map(obj -> new AprendizDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/listaN", method=RequestMethod.GET)
	public ResponseEntity<Page<AprendizDTO>> findAprendizName(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction,
			@RequestParam(value = "nome", defaultValue = "")String nome) {
		String nomeDecode = URL.decodeParam(nome); 
		Page<Aprendiz> lista = servico.search(nomeDecode, page, linesPerPage, orderBy, direction);
		Page<AprendizDTO> listaDTO = lista.map(obj -> new AprendizDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/listaC", method=RequestMethod.GET)
	public ResponseEntity<Page<AprendizDTO>> findAprendizCPF(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction,
			@RequestParam(value = "cpf", defaultValue = "")String cpf) {
		Page<Aprendiz> lista = servico.findAprendizCPF(page, linesPerPage, orderBy, direction, cpf);
		Page<AprendizDTO> listaDTO = lista.map(obj -> new AprendizDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AprendizNewDTO objDTO){
		Aprendiz obj = servico.fromDTO(objDTO);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}		
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AprendizDTO objDTO, @PathVariable Integer id){
		Aprendiz obj = servico.fromDTO(objDTO);	
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
