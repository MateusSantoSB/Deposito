package com.example.atividade.exceptions;



public class NameUserPresent extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NameUserPresent(String mensagem) {
		super(mensagem);
	}
	
	
}
