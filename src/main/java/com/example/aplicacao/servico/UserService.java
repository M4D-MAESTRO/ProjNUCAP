package com.example.aplicacao.servico;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.aplicacao.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
		
		
	}
	
}
