package com.example.aplicacao.servico;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.InstituicaoAprendiz;
import com.example.aplicacao.dominio.InstituicaoAprendizPK;
import com.example.aplicacao.dto.AtualizarAssocDTO;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.InstituicaoAprendizRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class AprendizInstituicaoService {

	@Autowired
	InstituicaoAprendizRepository repo;
	
	@Autowired
	InstituicaoRepository instituicao;
	
	@Autowired
	AprendizRepository aprendiz;

	public InstituicaoAprendiz find(Integer idAprendiz, Integer idInstituicao) {
		InstituicaoAprendiz obj = repo.findByIdAndId(idAprendiz, idInstituicao);
		// System.out.println(obj);
		return obj;
	}

	public InstituicaoAprendiz insert(InstituicaoAprendiz obj) {
		obj = repo.save(obj);
		// System.out.println(obj);
		return obj;
	}

	public InstituicaoAprendiz update(InstituicaoAprendiz obj) {
		repo.findById(obj.getId().getAprendiz().getId());
		InstituicaoAprendiz newObj = repo.findByIdAndId(obj.getId().getAprendiz().getId(), obj.getId().getInstituicao().getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(InstituicaoAprendiz newObj, InstituicaoAprendiz obj) {
		newObj.setDataDeInicio(obj.getDataDeInicio());
		newObj.setDataDeTermino(obj.getDataDeTermino());
		newObj.setPercentualDeFalta(obj.getPercentualDeFalta());
	}

	public InstituicaoAprendiz fromDTO(@Valid AtualizarAssocDTO objDTO) {
		InstituicaoAprendiz obj = new InstituicaoAprendiz();
		obj.setId(new InstituicaoAprendizPK(aprendiz.getOne(objDTO.getIdAprendiz()), instituicao.getOne(objDTO.getIdInstituicao())));
		
		return obj;
	}

}
