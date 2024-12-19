package com.example.atividade.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ErroDetalher> NotFundEx(IdNotFound ex){
		
		ErroDetalher erro=new ErroDetalher(
				"NotFound",
				404,
				ex.getMessage()
				
				);
		
		return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroDetalher> InvalidInput(MethodArgumentNotValidException ex){
		String mensagem = ex.getBindingResult().getFieldErrors().stream()
	            .map(FieldError::getDefaultMessage) .findFirst().
	            orElse("Erro de validação desconhecido");;
		
		
		ErroDetalher erro= new ErroDetalher(
				"Invalid Input", 
				400, 
				mensagem);
				return new ResponseEntity<>(erro,HttpStatus.BAD_REQUEST);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErroDetalher> NameUserIsPresent(NameUserPresent ex){
		ErroDetalher erro=new ErroDetalher(
				"O Login ja Existe", 
				409, 
				ex.getMessage()
				);
		return new ResponseEntity<>(erro,HttpStatus.CONFLICT);
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
