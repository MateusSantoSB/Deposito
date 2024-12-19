package com.example.atividade.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.atividade.controller.dto.UsuarioAtualizarDTO;
import com.example.atividade.controller.dto.UsuarioDTO;
import com.example.atividade.controller.dto.UsuarioDadosDTO;
import com.example.atividade.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	Usuario toEntity(UsuarioDTO dto);
	
	UsuarioDTO toDTO(Usuario usario);
	
	@Mapping(source="roles.role", target="roles")//mapeia o campo roles da classe usuario pegando a instancida da classe Role para pegar o campo role da propia
	UsuarioDadosDTO toDadosDTO(Usuario usuario);
	
	Usuario toEntity(UsuarioAtualizarDTO dto);
	
}
