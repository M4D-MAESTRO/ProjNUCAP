package com.example.aplicacao.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import com.example.aplicacao.dominio.Cidade;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dto.CidadeDTO;
import com.example.aplicacao.dto.InstituicaoDTO;
import com.example.aplicacao.dto.InstituicaoNewDTO;
import com.example.aplicacao.dto.ListaAprendizesDTO;
import com.example.aplicacao.servico.InstituicaoService;

@RestController
@RequestMapping(value = "/instituicao")
public class InstituicaoResource {
	
	@Autowired
	private InstituicaoService servico;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Instituicao obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}/alunos",method = RequestMethod.GET)
	public ResponseEntity<?> findAlunos(@PathVariable Integer id){
		Instituicao obj = servico.find(id);
		ListaAprendizesDTO listaDTO = new ListaAprendizesDTO(obj);
		return ResponseEntity.ok().body(listaDTO.getLista());
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="value") String email){
		Instituicao apr = servico.findByEmail(email);
		return ResponseEntity.ok().body(apr);
	}
	
	/*@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="name") String nome) {
		Instituicao obj = servico.findByName(nome);
		return ResponseEntity.ok().body(obj);
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<InstituicaoDTO>> getAll() {
		List<Instituicao> lista = servico.findAll();
		List<InstituicaoDTO> listaDTO = lista.stream().map(obj -> new InstituicaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<InstituicaoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		Page<Instituicao> lista = servico.findPage(page, linesPerPage, orderBy, direction);
		Page<InstituicaoDTO> listaDTO = lista.map(obj -> new InstituicaoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/listaN", method=RequestMethod.GET)
	public ResponseEntity<Page<InstituicaoDTO>> findInstituicaoName(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction,
			@RequestParam(value = "nome", defaultValue = "")String nome) {
		Page<Instituicao> lista = servico.findInstituicao(page, linesPerPage, orderBy, direction, nome);
		Page<InstituicaoDTO> listaDTO = lista.map(obj -> new InstituicaoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/listaT", method=RequestMethod.GET)
	public ResponseEntity<Page<InstituicaoDTO>> findInstituicaoTipo(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction,
			@RequestParam(value = "tipo", defaultValue = "")Integer tipo) {
		Page<Instituicao> lista = servico.findInstituicaoByTipo(page, linesPerPage, orderBy, direction, tipo);
		Page<InstituicaoDTO> listaDTO = lista.map(obj -> new InstituicaoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/listaC", method=RequestMethod.GET)
	public ResponseEntity<Page<InstituicaoDTO>> findInstituicaoCNPJ(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction,
			@RequestParam(value = "cnpj", defaultValue = "")String cnpj) {
		Page<Instituicao> lista = servico.findInstituicaoCNPJ(page, linesPerPage, orderBy, direction, cnpj);
		Page<InstituicaoDTO> listaDTO = lista.map(obj -> new InstituicaoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody InstituicaoDTO objDTO, @PathVariable Integer id){
		Instituicao obj = servico.fromDTO(objDTO);	
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InstituicaoNewDTO objDTO){
		Instituicao obj = servico.fromDTO(objDTO);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
