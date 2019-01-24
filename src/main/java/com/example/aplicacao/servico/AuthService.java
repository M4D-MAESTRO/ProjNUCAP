package com.example.aplicacao.servico;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.servico.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private AprendizRepository aprendizRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {
		Aprendiz aprendiz = aprendizRepository.findByEmail(email);
		if (aprendiz == null) {
			throw new ObjectNotFoundException("Email não encontrado!");
		}

		String newPass = newPassWord();
		aprendiz.setSenha(pe.encode(newPass));

		aprendizRepository.save(aprendiz);
		emailService.sendNewPasswordEmail(aprendiz, newPass);
	}

	private String newPassWord() {
		char vet[] = new char[10];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}

		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}

}

}
