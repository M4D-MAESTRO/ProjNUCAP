package com.example.aplicacao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.Pessoa;
import com.example.aplicacao.servico.AprendizService;
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
	
	/*@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="name") String nome) {
		Aprendiz obj = servico.findByName(nome);
		return ResponseEntity.ok().body(obj);
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Instituicao>> findAll() {
		List<Instituicao> obj = servico.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Instituicao obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Instituicao obj, @PathVariable Integer id){
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
