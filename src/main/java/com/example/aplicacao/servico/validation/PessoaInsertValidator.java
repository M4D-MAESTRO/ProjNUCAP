package com.example.aplicacao.servico.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dto.AprendizNewDTO;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.resources.exceptions.FieldMessage;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, AprendizNewDTO> {

	@Autowired
	private AprendizRepository repo;
	
	@Override
	public void initialize(PessoaInsert ann) {
	}

	@Override
	public boolean isValid(AprendizNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Aprendiz aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
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

