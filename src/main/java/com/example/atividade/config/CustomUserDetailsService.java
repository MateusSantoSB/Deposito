package com.example.atividade.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.atividade.model.Usuario;
import com.example.atividade.service.UsuarioService;

public class CustomUserDetailsService implements UserDetailsService {

	
	private final UsuarioService service;
	
	public CustomUserDetailsService(UsuarioService service) {
		this.service=service;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Usuario usuario=service.buscaLogin(username);
		if(usuario==null) {
			throw new UsernameNotFoundException("Usuario não encotrado");
		}
		
		return User.builder()
				.username(usuario.getLogin())
				.password(usuario.getSenha())
				.roles(usuario.getRoles().getRole())
				.build();
				
	}
	
}
