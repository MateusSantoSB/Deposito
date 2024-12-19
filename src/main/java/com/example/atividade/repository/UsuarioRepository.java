package com.example.atividade.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	Usuario findByLogin(String login);

	

}
