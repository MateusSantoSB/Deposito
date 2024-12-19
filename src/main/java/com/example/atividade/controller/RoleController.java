package com.example.atividade.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.atividade.controller.dto.RoleAtualizarDTO;
import com.example.atividade.controller.dto.RoleDTO;
import com.example.atividade.controller.dto.RoleDadosDTO;
import com.example.atividade.controller.dto.UsuarioDadosDTO;
import com.example.atividade.controller.mapper.RoleMapper;
import com.example.atividade.controller.mapper.UsuarioMapper;
import com.example.atividade.model.Role;
import com.example.atividade.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RoleController  {

	private final RoleService service;
	
	private final RoleMapper mapper;
	
	private final UsuarioMapper mapperUsuario;
	
	public RoleController(RoleService service,RoleMapper mapper,UsuarioMapper mapperUsuario) {
		this.service=service;
		this.mapper=mapper;
		this.mapperUsuario=mapperUsuario;
	}
	
	@PostMapping
	public ResponseEntity<URI> salvar(@RequestBody @Valid RoleDTO dto){
		
		Role role=mapper.toEntity(dto);
		service.salvar(role);
		

		
		URI loc= ServletUriComponentsBuilder.
					fromCurrentRequest().
					path("/"+role.getId()).
					build().
					toUri();
		
		
		
		return ResponseEntity.created(loc).build();
		
	}
	
	@GetMapping("listar/usuarios/{id}")
	public ResponseEntity<List<UsuarioDadosDTO>> listarUsuarios(@PathVariable long id){
		var usuarios=service.listarUsuariosPorRole(id);
		List<UsuarioDadosDTO> lista=usuarios.stream().map(mapperUsuario::toDadosDTO).toList();
		return ResponseEntity.ok(lista);	
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable long id ,@RequestBody RoleAtualizarDTO dto){
		service.atualizar(id, mapper.toEntity(dto));
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
	service.deletar(id);
		
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<RoleDadosDTO> buscar(@PathVariable Long id){
		Optional<Role> busca=service.buscar(id);
		if(busca.isPresent()) {
			RoleDadosDTO dto=mapper.toDadosDTO(busca.get());
			return ResponseEntity.ok(dto);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
