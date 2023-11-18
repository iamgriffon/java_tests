package com.fatec.biblioteca.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, Integer ano, Integer edicao) {
        if (titulo == null) {
            throw new NullPointerException("Nome inválido");
        }

        if (autor == null) {
            throw new NullPointerException("Autor inválido");
        }

        if (ano == null) {
            throw new NullPointerException("Ano inválido");
        } else if (ano > Year.now().getValue()) {
            throw new IllegalArgumentException("Ano inválido.");
        }

        if (edicao == null || edicao <= 0) {
            throw new IllegalArgumentException("Edicao inválida");
        }

        Livro livro = new Livro(titulo, autor, ano, edicao);
        livros.add(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public void atualizarLivro(String titulo, String novoTitulo, String novoAutor, Integer novoAno,
            Integer novaEdicao) {
        Livro livro = buscarLivroPorTitulo(titulo);

        if (livro == null) {
            throw new NullPointerException("Livro não encontrado");
        }

        if (novoTitulo == "" || novoAno > Year.now().getValue() || novoAutor == "" || novoAno <= 0 || novaEdicao <= 0) {
            throw new IllegalArgumentException("Dado(s) invalido(s)");
        }

        if (novoAno == null || novoTitulo == null || novaEdicao == null || novoAno == null) {
            throw new NullPointerException("Dados invalidos");
        }

        livro.setTitulo(novoTitulo);
        livro.setAutor(novoAutor);
        livro.setAno(novoAno);
        livro.setEdicao(novaEdicao);
    }

    public void removerLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        if (livro != null) {
            livros.remove(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
