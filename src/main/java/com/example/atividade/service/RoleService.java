package com.example.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.atividade.exceptions.IdNotFound;
import com.example.atividade.model.Role;
import com.example.atividade.model.Usuario;
import com.example.atividade.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Service
public class RoleService {

	private final RoleRepository repository;
	
	public RoleService(RoleRepository repository) {
		this.repository=repository;
	}
	
	@Transactional
	public void salvar(Role role) {
		repository.save(role);
	}
	
	public List<Usuario> listarUsuariosPorRole(Long id){
		Optional<Role> role=repository.findById(id);
		if(role.isEmpty()) {
			throw new IdNotFound("ID "+id+" Não encontrado!!");
		}
		var busca=role.get();
		
		return	busca.getUsuario();
	}
	
	
	public void atualizar(Long id,Role role) {
		Optional<Role> busca=repository.findById(id);
		if(busca.isEmpty()) {
			throw new IdNotFound("ID"+id+" Não encotrado!!");
		}
		var roleBusca=busca.get();
		
		if(role.getRole()!=null) {
			roleBusca.setRole(role.getRole());	
		}
		if(role.getDescricao()!=null) {
			roleBusca.setDescricao(role.getDescricao());	
		}
		
		this.salvar(roleBusca);
	}
	
	public void deletar(Long id) {
	Optional<Role> busca=repository.findById(id);
		
	if(busca.isEmpty()) {
		throw new IdNotFound("Id"+id+" Não encontrado");
	}
	if(this.listarUsuariosPorRole(id).isEmpty()) {
		repository.deleteById(id);
	}else {
		throw new RuntimeException("Impossivel deletar uma Role que contem Usuarios");
	}
	}
	
	
	
	public Optional<Role> buscar(Long id ) {
          Optional<Role> busca=repository.findById(id);
          
          if(busca.isEmpty()) {
        	  throw new IdNotFound("ID"+id+"Não encontrado");
          }
          return busca;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
