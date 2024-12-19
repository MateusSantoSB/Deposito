package com.example.atividade.service;

import java.util.Optional;
import java.util.UUID;
import com.example.atividade.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.atividade.exceptions.IdNotFound;
import com.example.atividade.exceptions.NameUserPresent;
import com.example.atividade.model.Usuario;
import com.example.atividade.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service 
public class UsuarioService {

	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder encoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository,PasswordEncoder encoder) {
		this.usuarioRepository=usuarioRepository;
		this.encoder=encoder;
		
	}
	
	
	
	
	@Transactional
	public void salvar(Usuario usuario) {
		Usuario busca=usuarioRepository.findByLogin(usuario.getLogin());
		if(busca==null) {
			var pass=usuario.getSenha();
			usuario.setSenha(encoder.encode(pass)); //aqui criptografamos a senha do usuario
			
			usuarioRepository.save(usuario);
		}else {
			throw new NameUserPresent("Nome de Login ja Cadastrado");
		}
		
		
		
	}
	
	public Optional<Usuario> buscar(UUID id) {	
		Optional<Usuario> usuario=usuarioRepository.findById(id);
		if(usuario.isEmpty()) {
			throw new IdNotFound("Id:"+id+"Não encontrado!!");
		}
		return usuario;
	}
	
	
	public Usuario buscaLogin(String login) {
	    Usuario usuario=usuarioRepository.findByLogin(login);
		
		return usuario;
		}
	
	public void atualizar(UUID id,Usuario usuario) {
		Optional<Usuario> buscar=usuarioRepository.findById(id);
		if(buscar.isEmpty()) {
			throw new IdNotFound("ID "+id+" não encontrado!!");
		}
		Usuario usuarioBusca=buscar.get();
		if(usuario.getLogin()!=null) {
			usuarioBusca.setLogin(usuario.getLogin());
			
		}
		if(usuario.getSenha()!=null) {
			usuarioBusca.setSenha(usuario.getSenha());
			var pass=usuarioBusca.getSenha();
			usuarioBusca.setSenha(encoder.encode(pass));
		}
		if(usuario.getNome()!=null) {
			usuarioBusca.setNome(usuario.getNome());
		}
		
		
		usuarioRepository.save(usuarioBusca);
		
	}
	
	public void deletar(UUID id) {
		Optional<Usuario> busca=usuarioRepository.findById(id);
		if(busca.isEmpty()) {
			throw new IdNotFound("ID "+id+" Não encontrado!!");
		}
		usuarioRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
