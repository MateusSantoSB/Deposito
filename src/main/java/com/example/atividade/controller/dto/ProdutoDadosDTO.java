package com.example.atividade.controller.dto;

import com.example.atividade.model.Produto;

public record ProdutoDadosDTO(String nome,Long id,Double preco,int quantidade) {

	public ProdutoDadosDTO(Produto produto) {
		this(produto.getNome(),produto.getId(),produto.getPreco(),produto.getQuantidade());
	}

}
