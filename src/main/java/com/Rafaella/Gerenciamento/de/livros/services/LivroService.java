package com.Rafaella.Gerenciamento.de.livros.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rafaella.Gerenciamento.de.livros.entities.Livro;
import com.Rafaella.Gerenciamento.de.livros.repositories.LivroRepository;

@Service
public class LivroService {
	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
}

	public Livro getlivrosById(Long id) {
		return livroRepository.findById(id).orElse(null);
}
	public List<Livro> getAlllivros(){
		return livroRepository.findAll();
}
	public Livro saveLivro (Livro livro) {
		return livroRepository.save(livro);
}

	public void deletelivros (Long id) {
		livroRepository.deleteById(id);
}

// fazendo o update do livros com o optional
	public Livro updatelivros(Long id, Livro novolivros) {
     java.util.Optional<Livro> livrosOptional = livroRepository.findById(id);
     if (livrosOptional.isPresent()) {
     	Livro LivrosExistente = livrosOptional.get();
        	LivrosExistente.setdescricao(novolivros.getdescricao());
     	LivrosExistente.setisbn(novolivros.getisbn());          
         return livroRepository.save(LivrosExistente); 
     } else {
         return null; 
     }
 }
	}
