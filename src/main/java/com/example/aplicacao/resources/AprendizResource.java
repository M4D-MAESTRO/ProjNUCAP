package com.example.aplicacao.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.aplicacao.dto.AprendizDTO;
import com.example.aplicacao.servico.AprendizService;

@RestController
@RequestMapping(value = "/aprendiz")
public class AprendizResource {
	
	@Autowired
	private AprendizService servico;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Aprendiz obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="name") String nome) {
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

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aprendiz obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}		
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Aprendiz obj, @PathVariable Integer id){
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
