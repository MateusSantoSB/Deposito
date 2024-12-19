package com.example.atividade.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record RoleDTO(
		
		
		@NotBlank(message = "Campo nome Role obrigatorio")
		String role,
		
		@NotBlank(message = "Campo Descricao obrigatorio")
		String descricao
		
		) {

}
