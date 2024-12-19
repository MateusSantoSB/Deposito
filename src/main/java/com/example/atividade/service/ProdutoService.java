package com.example.atividade.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade.controller.dto.ProdutoAtualizarDTO;
import com.example.atividade.exceptions.IdNotFound;
import com.example.atividade.model.Produto;
import com.example.atividade.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private DepositoService depositoService;
	
	@Transactional
	public void salvar(Produto produto) {
			produtoRepository.save(produto);
		
			
	}
	
	
	public Optional<Produto> buscarPorId(Long id) {
		Optional<Produto> buscar=produtoRepository.findById(id);
		if(buscar.isEmpty()) {
			throw new IdNotFound("ID:"+id+" Não encotrado!");
		}
		return buscar;
	
	
	}
	
	@Transactional
	public Produto atualizar(Long id,ProdutoAtualizarDTO dto) {
		Optional<Produto> buscar=this.buscarPorId(id);
		
		if(buscar.isEmpty()){
			throw new IdNotFound("ID:"+id+" Não encontrado!");
			
		}
		if(buscar.isPresent()) {
			Produto produto=buscar.get();
			if(dto.nome()!=null) {
				produto.setNome(dto.nome());
			}
			if(dto.categoria()!=null) {
				produto.setCategoria(dto.categoria());
			}
			if(dto.preco()!=null) {
				produto.setPreco(dto.preco());
			}
			if(dto.quantidade()!=0) {
				produto.setQuantidade(dto.quantidade());
			}
			this.salvar(produto);
			
			return produto;	
		}
		
	
			
		return null;
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	
	public void deletar(Long id) {
		Optional<Produto> produto=produtoRepository.findById(id);
		if(produto.isEmpty()) {
			throw new IdNotFound("ID:"+id+" Não encontrado!!");
		}
			produtoRepository.deleteById(id);
		
		
		
		
	}
	
	
	public List<Produto> buscarPorDeposito(UUID id){
		depositoService.buscar(id);
		
		List<Produto> produtos=produtoRepository.findByDeposito_Id(id);
		if(produtos.isEmpty()) {
			throw new IdNotFound("Deposito de ID:"+id+" Esta Vazio...");
		}
		
		return produtos;
	}
	
	
	
	
	
	
	
}
