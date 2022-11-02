package com.atividade.atividade.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbcategorias")
public class Categoria {

	@Id
	private String categoria;

	public Categoria() {

	}

	public Categoria(String categoria) {
		super();
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
