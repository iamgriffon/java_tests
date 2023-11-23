package com.fatec.biblioteca;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fatec.biblioteca.model.Biblioteca;
import com.fatec.biblioteca.model.Livro;

public class Req03AtualizarLivroTests {

  @Test
  void atualizarLivro() {
    Biblioteca biblioteca = new Biblioteca();
    Livro livro = new Livro("Titulo", "Autor", 1992, 2);
    biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
    biblioteca.atualizarLivro("Titulo", "Novo Titulo", livro.getAutor(), livro.getAno(), livro.getEdicao());
    assertTrue("Autor" == livro.getAutor());
  }

  @Test
  void atualizarLivroNulo1() {
    Biblioteca biblioteca = new Biblioteca();
    Livro livro = new Livro("Titulo", "Autor", 1992, 2);
    biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
    assertThrows(NullPointerException.class, () -> {
      biblioteca.atualizarLivro(null, "NovoTitulo", livro.getAutor(), livro.getAno(), livro.getEdicao());
    });
  }

  @Test
  void atualizarLivroNulo2() {
    Biblioteca biblioteca = new Biblioteca();
    Livro livro = new Livro("Titulo", "Autor", 1992, 2);
    biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
    assertThrows(NullPointerException.class, () -> {
      biblioteca.atualizarLivro("Titulo", null, livro.getAutor(), livro.getAno(), livro.getEdicao());
    });
  }

  @Test
  void atualizarLivroTituloVazio() {
    Biblioteca biblioteca = new Biblioteca();
    Livro livro = new Livro("Titulo", "Autor", 1992, 2);
    biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
    assertThrows(IllegalArgumentException.class, () -> {
      biblioteca.atualizarLivro("Titulo", "", livro.getAutor(), livro.getAno(), livro.getEdicao());
    });
  }
}
