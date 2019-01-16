package com.example.aplicacao.servico;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.aplicacao.dominio.Pessoa;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender jms;
	
	@Override
	public void sendRegistrationEmail(Pessoa obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromRegistro(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromRegistro(Pessoa obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Cadastro realizado com sucesso");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplateCadastro(Pessoa obj) {
		Context context = new Context();
		context.setVariable("aprendiz", obj);
		return templateEngine.process("email/confirmacaoRegistro", context);
	}
	
	@Override
	public void sendRegistrationHtmlEmail(Pessoa obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromRegistro(obj);
			sendHtmlEmail(mm); 
		} catch (MessagingException e) {
			sendRegistrationEmail(obj);
		}
		
	}

	protected MimeMessage prepareMimeMessageFromRegistro(Pessoa obj) throws MessagingException {
		MimeMessage mimeMessage = jms.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Cadastro realizado com sucesso!");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateCadastro(obj), true);
		
		return mimeMessage;
	}

}
