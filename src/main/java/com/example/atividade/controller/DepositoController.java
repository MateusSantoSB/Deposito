package com.example.atividade.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

import com.example.atividade.controller.dto.DepositoAtualizarDTO;
import com.example.atividade.controller.dto.DepositoDTO;
import com.example.atividade.controller.dto.DepositoDadosDTO;
import com.example.atividade.controller.mapper.DepositoMapper;
import com.example.atividade.model.Deposito;
import com.example.atividade.service.DepositoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deposito")
public class DepositoController {

	private final DepositoService depositoService;
	
	
	private final DepositoMapper depositoMapper;
	
	
	public DepositoController(DepositoService depositoService,DepositoMapper depositoMapper) {
		this.depositoService=depositoService;
		this.depositoMapper=depositoMapper;
	}
	
	
	
	
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid DepositoDTO dto){
		Deposito deposito=depositoMapper.toEntity(dto);
		
		depositoService.salvar(deposito);

		
		URI loc=ServletUriComponentsBuilder.
					fromCurrentRequest().
					path("/"+deposito.getId()).
					build().
					toUri();
	
		
		
		return ResponseEntity.created(loc).build();
	}	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DepositoDadosDTO> buscar(@PathVariable UUID id){
		Optional<Deposito> dep=depositoService.buscar(id);
		Deposito deposito=dep.get();
		DepositoDadosDTO dados=depositoMapper.toDtoDados(deposito);
		return ResponseEntity.ok(dados);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Deposito> atualizar(@PathVariable UUID id,@RequestBody DepositoAtualizarDTO dto){
		depositoService.atualizar(id,depositoMapper.toEntity(dto));
		
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable UUID id){
		
		depositoService.deletar(id);
		
		return ResponseEntity.ok().build();
	}
	@GetMapping("/listar")
	public ResponseEntity<List<DepositoDadosDTO>> listar(){
		List<Deposito> deposito=depositoService.listar();
		List<DepositoDadosDTO> dto=deposito.stream().map(depositoMapper::toDtoDados).toList();
		return ResponseEntity.ok(dto);
	}
	
	
	
	
	
	
	
	

}



























