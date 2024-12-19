package com.example.atividade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.atividade.model.Role;
import com.example.atividade.model.Usuario;
import com.example.atividade.service.RoleService;
import com.example.atividade.service.UsuarioService;

@SpringBootTest
class DepositoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UsuarioService ususervice;
	
	@Autowired
	private RoleService roleservice;
	
	
	
	
	
	
	@Test
	public void iniciarUsuario() {
		Role role=new Role();
		role.setRole("ADM");
		role.setDescricao("Acessa todos os End-poitns");
		roleservice.salvar(role);
		
		
		Usuario usuario=new Usuario();
		usuario.setLogin("adm");
		usuario.setSenha("adm");
		usuario.setNome("admin");
		usuario.setRoles(role);
		
		
		ususervice.salvar(usuario);
		System.out.println("ID:"+usuario.getId());
		System.out.println("Login:"+usuario.getLogin());
		System.out.println("Senha:"+usuario.getSenha());
		System.out.println("Nome:"+usuario.getNome());

	}

}
