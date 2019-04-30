package com.example.aplicacao.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.InstituicaoAprendiz;

public class ListaInstituicoesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<InstituicaoAuxDTO> lista = new ArrayList<>();

	public ListaInstituicoesDTO() {

	}

	public ListaInstituicoesDTO(Aprendiz obj) {
		List<InstituicaoAprendiz> listaAux = new ArrayList<>();
		listaAux = obj.getInstituicoes();
		
		for (int i = 0; i < listaAux.size(); i++) {
			lista.add(new InstituicaoAuxDTO(listaAux.get(i).getId().getAprendiz(), i));
		}

	}

	public List<InstituicaoAuxDTO> getLista() {
		return lista;
	}

	public void setLista(List<InstituicaoAuxDTO> lista) {
		this.lista = lista;
	}

}
