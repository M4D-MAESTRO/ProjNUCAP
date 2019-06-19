package com.example.aplicacao.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.aplicacao.dominio.Cidade;
import com.example.aplicacao.dominio.Estado;
import com.example.aplicacao.dto.CidadeDTO;
import com.example.aplicacao.dto.EstadoDTO;
import com.example.aplicacao.servico.CidadeService;
import com.example.aplicacao.servico.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService serviceEstado;
	
	@Autowired	
	private CidadeService serviceCidade;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Estado> estados = serviceEstado.findAll();
		List<EstadoDTO> estadosDTO = estados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(estadosDTO);
	}
	

	
	@RequestMapping(value = "/{estadoId}/cidades",method = RequestMethod.GET)
	public ResponseEntity<?> findCidades(@PathVariable Integer estadoId){
		List<Cidade> cidades = serviceCidade.findByEstado(estadoId);
		List<CidadeDTO> cidadesDTO = cidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		cidadesDTO.stream().forEach(cidade -> System.out.println(cidade.getId() + " - " + cidade.getNome()));
		return ResponseEntity.ok().body(cidadesDTO);
	}

}
