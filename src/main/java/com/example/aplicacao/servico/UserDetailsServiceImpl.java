package com.example.aplicacao.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.aplicacao.dominio.Aprendiz;
import com.example.aplicacao.dominio.Pessoa;
import com.example.aplicacao.repositories.AprendizRepository;
import com.example.aplicacao.repositories.PessoaRepository;
import com.example.aplicacao.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AprendizRepository repo;
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Pessoa apr = pessoaRepo.findByEmail(email);
		if(apr == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(apr.getId(), apr.getEmail(), apr.getSenha(), apr.getPerfis());
	}

}
