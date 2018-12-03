package com.example.aplicacao.servico;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teste")
public class Relatorio {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
	return "REST está funcionando!";
	}

}
