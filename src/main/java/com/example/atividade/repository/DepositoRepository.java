package com.example.atividade.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade.model.Deposito;

public interface DepositoRepository extends JpaRepository<Deposito, UUID> {
	
	
	//@Query(value="SELECT p.nome FROM produtos p JOIN deposito d ON p.desposito_id=d.id WHERE d.id= :id")
	//List<Produto> findByProdutos();
	
	
}
