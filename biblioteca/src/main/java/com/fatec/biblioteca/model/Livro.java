package com.fatec.biblioteca.model;

public class Livro {
	public Livro(String titulo, String autor, Integer ano, Integer edicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.edicao = edicao;
	}

	protected String titulo;
	protected String autor;
	protected Integer ano;
	protected Integer edicao;

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
