package com.example.atividade.controller.mapper;

import org.mapstruct.Mapper;

import com.example.atividade.controller.dto.RoleAtualizarDTO;
import com.example.atividade.controller.dto.RoleDTO;
import com.example.atividade.controller.dto.RoleDadosDTO;
import com.example.atividade.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	Role toEntity(RoleDTO dto);
	
	RoleDTO toDTO(Role role);
	
	
	Role toEntity(RoleDadosDTO dadosDTO);
	
	RoleDadosDTO toDadosDTO(Role role);
	
	Role toEntity(RoleAtualizarDTO dto);
}
