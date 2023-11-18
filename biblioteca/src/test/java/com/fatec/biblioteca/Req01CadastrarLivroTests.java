package com.fatec.biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fatec.biblioteca.model.Biblioteca;
import com.fatec.biblioteca.model.Livro;

class Req01CadastrarLivroTests {

	@Test
	public void testCadastrarLivroSucesso() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.adicionarLivro("Livro1", "Autor1", 2022, 1);

		Livro livroCadastrado = biblioteca.buscarLivroPorTitulo("Livro1");

		assertNotNull(livroCadastrado, "Livro1 não cadastrado");
		assertEquals("Livro1", livroCadastrado.getTitulo());
		assertEquals("Autor1", livroCadastrado.getAutor());
		assertEquals(Integer.valueOf(2022), livroCadastrado.getAno());
		System.out.println("Teste 1 Executado");
	}

	@Test
	public void testCadastrarLivroNomeInvalido() {
		Biblioteca biblioteca = new Biblioteca();
		assertThrows(NullPointerException.class, () -> {
			biblioteca.adicionarLivro(null, "Author1", 2023, 1);
		});
		System.out.println("Teste 2 Executado");
	}

	@Test
	void testCadastrarAutorInvalido() {
		Biblioteca biblioteca = new Biblioteca();
		assertThrows(NullPointerException.class, () -> {
			biblioteca.adicionarLivro("Title", null, 2023, 1);
		});
		System.out.println("Teste 3 Executado");
	}

	@Test
	void testCadastrarEdicaoInvalida() {
		Biblioteca biblioteca = new Biblioteca();
		assertThrows(IllegalArgumentException.class, () -> {
			biblioteca.adicionarLivro("Title", "Autor3", 2023, -1);
		});
		System.out.println("Teste 4 Executado");
	}

	@Test
	void testCadastrarAnoInvalido() {
		Biblioteca biblioteca = new Biblioteca();
		assertThrows(IllegalArgumentException.class, () -> {
			biblioteca.adicionarLivro("Title", "Autor4", 2025, 3);
		});
		System.out.println("Teste 5 Executado");
	}

	@Test
	void testCadastrarAnoNulo() {
		Biblioteca biblioteca = new Biblioteca();
		assertThrows(NullPointerException.class, () -> {
			biblioteca.adicionarLivro("Title", "Autor4", null, 3);
		});
		System.out.println("Teste 5 Executado");
	}

}
