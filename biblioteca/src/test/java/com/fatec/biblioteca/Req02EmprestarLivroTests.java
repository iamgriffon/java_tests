package com.fatec.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fatec.biblioteca.model.Biblioteca;
import com.fatec.biblioteca.model.Usuario;

public class Req02EmprestarLivroTests {

	@Test
	void emprestarLivroSuccess() {
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario = new Usuario("usuario1");
		biblioteca.adicionarLivro("Livro1", "Autor1", 2022, 1);
		usuario.alugarLivro(biblioteca, "Livro1");
		usuario.consultarLivro();
		assertNotNull(usuario.getLivro());
		assertEquals("Livro1", usuario.getLivro().getTitulo());
	}

	@Test
	void devolverLivroSuccess() {
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario = new Usuario("usuario1");
		biblioteca.adicionarLivro("Livro1", "Autor1", 2022, 1);
		usuario.alugarLivro(biblioteca, "Livro1");
		assertNotNull(usuario.getLivro());
		usuario.devolverLivro(biblioteca);
		assertNotNull(biblioteca.listarLivros());
	}

	@Test
	void emprestarLivroQueNaoPode() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.adicionarLivro("Livro1", "Autor1", 2022, 1);
		biblioteca.adicionarLivro("Livro2", "Autor2", 2023, 2);
		Usuario usuario = new Usuario("usuario1");
		usuario.alugarLivro(biblioteca, "Livro1");
		usuario.consultarLivro();
		usuario.alugarLivro(biblioteca, "Livro2");
		assertNotNull(usuario.getLivro());
		assertEquals("Livro1", usuario.getLivro().getTitulo());
		assertNotNull(biblioteca.buscarLivroPorTitulo("Livro2"));
		System.out.println("Teste emprestadorLivroQueNaoPode realizado \n");
	}

	@Test
	void emprestarLivroQueNaoExiste() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.adicionarLivro("Livro1", "Autor1", 2022, 1);
		biblioteca.adicionarLivro("Livro2", "Autor2", 2023, 2);
		Usuario usuario = new Usuario("usuario1");
		usuario.alugarLivro(biblioteca, "Livro3");
		usuario.consultarLivro();
		assertNull(usuario.getLivro());
		assertNull(biblioteca.buscarLivroPorTitulo("Livro3"));
		System.out.println("Teste emprestarLivroQueNaoExiste realizado \n");
	}

	@Test
	void devolverLivroQueNaoTem() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.adicionarLivro("Livro1", "Autor1", 2022, 1);
		Usuario usuario = new Usuario("usuario1");
		usuario.devolverLivro(biblioteca);
		assertNull(usuario.getLivro());
		assertNotNull(biblioteca.listarLivros());
		System.out.println("Teste devolverLivroQueNaoTem realizado \n");
	}
}
