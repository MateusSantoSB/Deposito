package com.example.atividade.controller.mapper;

import org.mapstruct.Mapper;

import com.example.atividade.controller.dto.DepositoAtualizarDTO;
import com.example.atividade.controller.dto.DepositoDTO;
import com.example.atividade.controller.dto.DepositoDadosDTO;
import com.example.atividade.model.Deposito;

@Mapper(componentModel = "spring")
public interface DepositoMapper {


	Deposito toEntity(DepositoDTO dto);
	DepositoDTO toDto(Deposito deposito);
	
	Deposito toEntityDados(DepositoDadosDTO dto);
	DepositoDadosDTO toDtoDados(Deposito deposito);
	
	Deposito toEntity(DepositoAtualizarDTO dto);
}
