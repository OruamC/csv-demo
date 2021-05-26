package com.readcsv.democsv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Escola implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "status")
	private String status;

	public Escola() {
		super();
	}

	public Escola(Long id, String nome, String categoria, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Escola [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", status=" + status + "]";
	}
	
}
