package com.Rafaella.Gerenciamento.de.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rafaella.Gerenciamento.de.livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
