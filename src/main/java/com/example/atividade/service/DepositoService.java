package com.example.atividade.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade.controller.dto.DepositoAtualizarDTO;
import com.example.atividade.exceptions.IdNotFound;
import com.example.atividade.model.Deposito;
import com.example.atividade.model.Produto;
import com.example.atividade.repository.DepositoRepository;
import com.example.atividade.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class DepositoService {

	@Autowired
	private DepositoRepository depositoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Deposito salvar(Deposito deposito) {
		return depositoRepository.save(deposito);
	}
	
	
	public void atualizar(UUID id,Deposito deposito){
		Optional<Deposito>busca=depositoRepository.findById(id);
		if(busca.isEmpty()) {
			throw new IdNotFound("Id"+id+" Não encontrado!!");
		}
		
		
		
		Deposito depositoBuscar=busca.get();
		if(deposito.getNome()!=null) {
			depositoBuscar.setNome(deposito.getNome());
		}
		if(deposito.getCidade()!=null) {
			depositoBuscar.setCidade(deposito.getCidade());
		}
		if(deposito.getEndereco()!=null) {
			depositoBuscar.setEndereco(deposito.getEndereco());
		}

		depositoRepository.save(depositoBuscar);
		
	}
	
	public Optional<Deposito> buscar(UUID id){
		Optional<Deposito> deposito=depositoRepository.findById(id);
		if(deposito.isEmpty()) {
			throw new IdNotFound("Id:"+id+" Não encotrado");
		}
		return deposito;
		
	}
	
	
	public void deletar(UUID id) {
	List<Produto>lista=produtoRepository.findByDeposito_Id(id);
		
	if(lista.isEmpty()){
		depositoRepository.deleteById(id);
	}else {
		throw new RuntimeException("Impossivel deletar um Deposito que contem produtos!!");
	}	
	}
	
	public List<Deposito> listar() {
		return depositoRepository.findAll();
		
	}
	
	
	
}




















