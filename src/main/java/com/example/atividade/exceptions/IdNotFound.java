package com.example.atividade.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;

public class IdNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotFound(String message) {
		super(message);
	}
	
	public IdNotFound(DefaultMessageSourceResolvable ex) {
		ex.getDefaultMessage();
	}
	
	
}
