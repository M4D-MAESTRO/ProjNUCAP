package com.example.aplicacao.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Pessoa;
import com.example.aplicacao.servico.AprendizService;

@RestController
@RequestMapping(value = "/teste")
public class AprendizResource {
	
	@Autowired
	private AprendizService servico;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Aprendiz obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aprendiz obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
