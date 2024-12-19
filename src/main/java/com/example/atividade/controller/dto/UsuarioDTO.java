package com.example.atividade.controller.dto;

import com.example.atividade.model.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(		
		@NotBlank(message = "Campo login obrigatorio")
		String login,
		
		@NotBlank(message = "Campo login obrigatorio")
		String senha,
		
		@NotBlank(message = "Campo login obrigatorio")
		String nome,
		
		@NotNull(message = "Campo login obrigatorio")
		Role roles
		) {

}
