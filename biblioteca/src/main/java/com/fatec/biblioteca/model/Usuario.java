package com.fatec.biblioteca.model;

public class Usuario {
    private String nome;
    private Livro livro;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Livro getLivro() {
        return livro;
    }

    public void alugarLivro(Biblioteca biblioteca, String titulo) {
        if (livro == null) {
            Livro livroParaAlugar = biblioteca.buscarLivroPorTitulo(titulo);
            if (livroParaAlugar != null) {
                biblioteca.removerLivro(titulo);
                livro = livroParaAlugar;
                System.out.println(nome + " alugou o livro: " + livro.getTitulo());
            } else {
                System.out.println("Livro não encontrado na biblioteca.");
            }
        } else {
            System.out.println(nome + " já possui um livro alugado.");
        }
    }

    public void devolverLivro(Biblioteca biblioteca) {
        if (livro != null) {
            System.out.println(nome + " devolveu o livro: " + livro.getTitulo());
            biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
            livro = null;
        } else {
            System.out.println(nome + " não possui nenhum livro para devolver.");
        }
    }

    public void consultarLivro() {
        if (livro != null) {
            System.out.println(nome + " está com o livro: " + livro.getTitulo());
        } else {
            System.out.println(nome + " não está com nenhum livro no momento.");
        }
    }
}