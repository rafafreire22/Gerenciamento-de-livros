package com.Rafaella.Gerenciamento.de.livros.controller;


	import java.util.List;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.RequestEntity;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.Rafaella.Gerenciamento.de.livros.entities.Livro;
import com.Rafaella.Gerenciamento.de.livros.services.LivroService;


	

	@RestController
	@RequestMapping("/Livros")
	public class LivroController {

		//@GetMapping("/home")
			@GetMapping("/home")
		    public String paginaInicial() {
		        return "index"; // Nome do seu arquivo HTML (sem a extensão)
		    }
			private final LivroService livroService;
			
			public LivroController(LivroService livroService) {
				this.livroService = livroService;		
			}
			@GetMapping("/{id}")	
		    public ResponseEntity<Livro> getJogo(@PathVariable Long id) {
		        Livro livro = livroService.getlivrosById(id);
		        if (livro != null) {
		            return ResponseEntity.ok(livro);
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }	
			@PostMapping
			public Livro createLivro(@RequestBody Livro livro) {
				return livroService.saveLivro(livro);
			}
			
			@GetMapping
			public ResponseEntity<List<Livro>> getAllJogos(RequestEntity<Void> requestEntity) {
				String method = requestEntity.getMethod().name();
				String contentType = requestEntity.getHeaders().getContentType().toString();
				List<Livro> jogos = livroService.getAlllivros();
				return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
						.body(jogos);
			}
			
			@DeleteMapping("/{id}")
			public void deleteJogo(@PathVariable Long id) {
				livroService.deletelivros(id);
			}
			@PutMapping("/{id}")
			public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
			    return livroService.updatelivros(id, livro);
			}
			

	}
