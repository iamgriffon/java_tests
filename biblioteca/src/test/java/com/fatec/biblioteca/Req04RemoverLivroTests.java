package com.fatec.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fatec.biblioteca.model.Biblioteca;
import com.fatec.biblioteca.model.Livro;

public class Req04RemoverLivroTests {
  @Test
  void removerLivroSuccess() {
    Biblioteca biblioteca = new Biblioteca();
    Livro livro = new Livro("Titulo", "Autor", 1992, 2);
    biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
    biblioteca.listarLivros();
    biblioteca.removerLivro("Titulo");
    assertTrue(biblioteca.listarLivros().size() == 0);
  }

  @Test
  void removerLivroQueNaoExiste() {
    Biblioteca biblioteca = new Biblioteca();
    Livro livro = new Livro("Titulo", "Autor", 1992, 2);
    biblioteca.adicionarLivro(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getEdicao());
    biblioteca.removerLivro("Titulo2");
    assertEquals(1, biblioteca.listarLivros().size());
    assertNull(biblioteca.buscarLivroPorTitulo("Titulo2"));
  }
}
