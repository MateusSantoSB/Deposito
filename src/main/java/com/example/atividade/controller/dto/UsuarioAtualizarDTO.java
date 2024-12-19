package com.example.atividade.controller.dto;

import com.example.atividade.model.Role;

public record UsuarioAtualizarDTO(String login,String senha,String nome,Role roles) {

}
