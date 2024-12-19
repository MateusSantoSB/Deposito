package com.example.atividade.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record DepositoDTO(
		@NotBlank(message = "Campo nome obrigatorio")
		String nome,
		
		@NotBlank(message = "Campo nome obrigatorio")
		String cidade,
		
		@NotBlank(message = "Campo nome obrigatorio")
		String endereco
		
		) {

}
