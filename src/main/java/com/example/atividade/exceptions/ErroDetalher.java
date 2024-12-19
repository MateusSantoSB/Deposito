package com.example.atividade.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ErroDetalher {

	private String title;
	private int status;
	private String detalhe;
	private LocalDate data;
	
	

	public ErroDetalher(String title, int status, String detalhe) {
		super();
		this.title = title;
		this.status = status;
		this.detalhe = detalhe;
		this.data=LocalDate.now();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
	
	
}
