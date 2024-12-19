package com.example.atividade.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.atividade.controller.dto.UsuarioAtualizarDTO;
import com.example.atividade.controller.dto.UsuarioDTO;
import com.example.atividade.controller.dto.UsuarioDadosDTO;
import com.example.atividade.controller.mapper.UsuarioMapper;
import com.example.atividade.model.Usuario;
import com.example.atividade.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody UsuarioDTO dto){
		Usuario usuario=usuarioMapper.toEntity(dto);
		
		usuarioService.salvar(usuario);


			URI loc= ServletUriComponentsBuilder.
					fromCurrentRequest().
					path("/"+usuario.getId()).
					build().
					toUri();
		return ResponseEntity.created(loc).build();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<UsuarioDadosDTO> buscar(@PathVariable UUID id){
		var buscar=usuarioService.buscar(id);
		Usuario usuario=buscar.get();
		UsuarioDadosDTO dto=usuarioMapper.toDadosDTO(usuario);
		return ResponseEntity.ok(dto);
	}
	
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable UUID id,@RequestBody UsuarioAtualizarDTO dto){
		usuarioService.atualizar(id, usuarioMapper.toEntity(dto));	
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable    UUID id){
		usuarioService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
