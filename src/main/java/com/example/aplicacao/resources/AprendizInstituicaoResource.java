package com.example.aplicacao.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.InstituicaoAprendiz;
import com.example.aplicacao.dto.AtualizarAssocDTO;
import com.example.aplicacao.dto.InstituicaoDTO;
import com.example.aplicacao.dto.InstituicaoNewDTO;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.servico.AprendizInstituicaoService;

@RestController
@RequestMapping(value = "/atualizacao")
public class AprendizInstituicaoResource {
	
	@Autowired
	AprendizInstituicaoService servico;
	
	
	
	@RequestMapping(value="/att", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AtualizarAssocDTO objDTO){
		InstituicaoAprendiz obj = servico.fromDTO(objDTO);	
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AtualizarAssocDTO objDTO){
		InstituicaoAprendiz obj = servico.fromDTO(objDTO);
		obj = servico.insert(obj)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
