package com.example.atividade.controller.dto;

import java.util.UUID;
import com.example.atividade.model.Deposito;

public record DepositoDadosDTO(UUID id,String nome) {

	public DepositoDadosDTO(Deposito deposito) {
		this(deposito.getId(),deposito.getNome());
	}

}
