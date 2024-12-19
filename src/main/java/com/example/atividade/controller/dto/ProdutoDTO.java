package com.example.atividade.controller.dto;

import java.time.LocalDate;

import com.example.atividade.model.Deposito;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
		Long id,
		@NotBlank(message = "Campo nome obrigatorio")
		String nome,
		
		@NotBlank(message = "Campo categoria obrigatorio")
		String categoria,
		
		@NotNull(message = "Campo preco obrigatorio")
		Double preco,
		
		@NotNull(message = "Campo quantidade obrigatorio")
		int quantidade,
		
		@NotNull(message = "Campo deposito obrigatorio")
		Deposito deposito,
		
		@NotNull(message = "Campo validade obrigatorio")
		LocalDate validade,
		@NotNull(message = "Campo tamanho obrigatorio")
		Double tamanho
		
		) {

	

	

}
