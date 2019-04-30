package com.example.aplicacao.servico;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.aplicacao.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {

		try {
			
			UserSS principal = (UserSS)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println("Meu USER na autenticação: " + principal);
			return principal;
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
			return null;
		}

	}

}
