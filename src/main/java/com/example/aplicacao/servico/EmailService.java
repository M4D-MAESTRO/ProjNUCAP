package com.example.aplicacao.servico;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Pessoa;

public interface EmailService {

	void sendRegistrationEmail(Pessoa obj);

	void sendEmail(SimpleMailMessage msg);

	void sendRegistrationHtmlEmail(Pessoa obj);

	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Pessoa pessoa, String newPass);

}
