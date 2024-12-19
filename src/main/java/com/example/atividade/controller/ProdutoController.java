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

import com.example.atividade.controller.dto.ProdutoAtualizarDTO;
import com.example.atividade.controller.dto.ProdutoDTO;
import com.example.atividade.controller.dto.ProdutoDadosDTO;
import com.example.atividade.controller.mapper.ProdutoMapper;
import com.example.atividade.model.Produto;
import com.example.atividade.service.ProdutoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoMapper mapper;
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid ProdutoDTO dto){
		Produto produto= mapper.toEntity(dto);
		produtoService.salvar(produto);
		

		URI loc= ServletUriComponentsBuilder.
					fromCurrentRequest().
					path("/"+produto.getId()).
					build().
					toUri();
		
		
		return ResponseEntity.created(loc).build();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDadosDTO> buscar(@PathVariable Long id){
		Optional<Produto>produto= produtoService.buscarPorId(id);
		
		if(produto.isPresent()) {
			Produto prod=produto.get();
			ProdutoDadosDTO dados=mapper.toDadosDTO(prod);
			return ResponseEntity.ok(dados);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<ProdutoAtualizarDTO> atualizar(@PathVariable Long id,@RequestBody ProdutoAtualizarDTO dto){
	var produto= produtoService.atualizar(id, dto);
		
		if(produto!=null) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	@GetMapping("/listar")
	public ResponseEntity<List<ProdutoDadosDTO>> listar(){
		var produto=produtoService.listar();
		
		List<ProdutoDadosDTO> dto=produto.stream().map(mapper::toDadosDTO).toList();
		
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		produtoService.deletar(id);
		
		return ResponseEntity.ok(null);
	} 
	
	
	@GetMapping("/depositos/{id}")
	public ResponseEntity<List<ProdutoDadosDTO>> listarProdutosDeposito(@PathVariable UUID id){
		var produto=produtoService.buscarPorDeposito(id);
		
		var dto=produto.stream().map(ProdutoDadosDTO::new).toList();
		
		return ResponseEntity.ok(dto);
	}
	
	
	

}





























