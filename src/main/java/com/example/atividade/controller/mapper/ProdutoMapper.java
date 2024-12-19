package com.example.atividade.controller.mapper;

import org.mapstruct.Mapper;

import com.example.atividade.controller.dto.ProdutoDTO;
import com.example.atividade.controller.dto.ProdutoDadosDTO;
import com.example.atividade.model.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

	Produto toEntity(ProdutoDTO dto);
	
	ProdutoDTO toDTO(Produto produto);
	
	ProdutoDadosDTO toDadosDTO(Produto produto);

	
	
	
	
}
