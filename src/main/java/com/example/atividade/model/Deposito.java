package com.example.atividade.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.example.atividade.controller.dto.DepositoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="deposito")

public class Deposito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "deposito")
	private List<Produto> produtos=new ArrayList<>();
	
	@Column
    private String cidade;
    
	@Column
    private String endereco;
    
    
	
	
	public Deposito(DepositoDTO dto){
		this.nome=dto.nome();
		
	}
	
	public Deposito(){
		
		
	}



	

	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, produtos);
	}











	@Override
	public String toString() {
		return "Deposito [id=" + id + ", nome=" + nome + ", produtos=" + produtos + "]";
	}











	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposito other = (Deposito) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(produtos, other.produtos);
	}


	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<Produto> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
	
	
}




