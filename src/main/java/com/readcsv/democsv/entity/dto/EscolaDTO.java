package com.readcsv.democsv.entity.dto;

import com.opencsv.bean.CsvBindByPosition;

public class EscolaDTO {

	@CsvBindByPosition(position = 0)
	private String nome;
	
	@CsvBindByPosition(position = 1)
	private String categoria;
	
	@CsvBindByPosition(position = 2)
	private String status;
	
	public EscolaDTO() {
		super();
	}

	public EscolaDTO(String nome, String categoria, String status) {
		super();
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

	@Override
	public String toString() {
		return "EscolaDTO [nome=" + nome + ", categoria=" + categoria + ", status=" + status + "]";
	}
	
}
