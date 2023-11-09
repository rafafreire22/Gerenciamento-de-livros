package com.Rafaella.Gerenciamento.de.livros.entities;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "tb_livros")
	public class Livro {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String descricao;
		
		private String isbn ;
		
		public Livro() {
			
		}
		
		public Livro(Long id, String descricao, String isbn) {
			super();
			this.id = id;
			this.descricao = descricao;
			this.isbn = isbn;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getdescricao() {
			return descricao;
		}

		public void setdescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getisbn() {
			return isbn;
		}

		public void setisbn(String isbn) {
			this.isbn = isbn;
		}
		
	}

