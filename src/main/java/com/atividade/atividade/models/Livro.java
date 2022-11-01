package com.atividade.atividade.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tblivros")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codlivro;
	
	private String titulo;
	
	private String autor;
	
	private String categoria;
	
	private String valor;
	
	public Livro() {
		
	}

	public Livro(String titulo, String autor, String categoria, String valor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.valor = valor;
	}

	
	public int getCodlivro() {
		return codlivro;
	}

	public void setCodlivro(int codlivro) {
		this.codlivro = codlivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "Livro: " + getTitulo() + " Autor: " + getAutor() + " Valor: " + getValor() + " Categoria: " + getCategoria();
	}
	
	
}
