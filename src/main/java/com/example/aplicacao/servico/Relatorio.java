package com.example.aplicacao.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.example.aplicacao.dominio.Endereco;
import com.example.aplicacao.dominio.Pessoa;

@RestController
@RequestMapping(value = "/teste")
public class Relatorio {
	
	@Autowired
	private PessoaService servico;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pessoa obj = servico.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
