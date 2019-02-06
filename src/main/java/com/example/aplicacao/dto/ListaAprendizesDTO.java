package com.example.aplicacao.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dominio.InstituicaoAprendiz;

public class ListaAprendizesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<AprendizAuxDTO> lista = new ArrayList<>();

	public ListaAprendizesDTO() {

	}

	public ListaAprendizesDTO(Instituicao obj) {
		List<InstituicaoAprendiz> listaAux = new ArrayList<>();
		listaAux = obj.getAprendizes();
		
		for (int i = 0; i < listaAux.size(); i++) {
			lista.add(new AprendizAuxDTO(listaAux.get(i).getId().getInstituicao(), i));
		}

	}

	public List<AprendizAuxDTO> getLista() {
		return lista;
	}

	public void setLista(List<AprendizAuxDTO> lista) {
		this.lista = lista;
	}

}
