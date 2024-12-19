package com.example.atividade.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_produto")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="preco")
	private Double preco;
	
	@Column(name="quantidade")
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "deposito_id")
	private Deposito deposito;
	
	@Column(name="validade")
	private LocalDate validade;
	
	@Column(name="tamanho")
	private double tamanho;
	
	
	
	
	
	
	public Produto() {
		
		
	}
	
	
	
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Deposito getDeposito() {
		return deposito;
	}


       

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}




	public LocalDate getValidade() {
		return validade;
	}









	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}









	public double getTamanho() {
		return tamanho;
	}









	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}









	@Override
	public int hashCode() {
		return Objects.hash(categoria, id, nome, preco, quantidade);
	}









	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& quantidade == other.quantidade;
	}









	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco
				+ ", quantidade=" + quantidade + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
