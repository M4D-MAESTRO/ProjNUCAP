
package com.example.aplicacao.servico.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Instituicao;
import com.example.aplicacao.dto.AprendizDTO;
import com.example.aplicacao.dto.InstituicaoDTO;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.InstituicaoRepository;
import com.example.aplicacao.resources.exceptions.FieldMessage;

public class InstituicaoUpdateValidator implements ConstraintValidator<InstituicaoUpdate, InstituicaoDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private AprendizRepository repo;
	
	@Autowired
	private InstituicaoRepository repoInsti;
	
	

	@Override
	public void initialize(InstituicaoUpdate ann) {
	}

	@Override
	public boolean isValid(InstituicaoDTO objDto,  ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		Aprendiz aux = repo.findByEmail(objDto.getEmail());
		Instituicao aux2 = repoInsti.findByEmail(objDto.getEmail());
		
		if ((aux != null && !(aux.getId().equals(uriId))) || ((aux2 != null && !(aux2.getId().equals(uriId))))) {
			list.add(new FieldMessage("email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
