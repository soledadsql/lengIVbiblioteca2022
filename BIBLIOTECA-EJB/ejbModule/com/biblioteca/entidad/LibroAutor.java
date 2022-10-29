package com.biblioteca.entidad;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros_autores")
public class LibroAutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	LibroAutorPK id;

	@ManyToOne
	@JoinColumn(name = "lau_libro", insertable = false, updatable = false)
	private Libro libro;

	@ManyToOne
	@JoinColumn(name = "lau_autor", insertable = false, updatable = false)
	private Autor autor;

	public LibroAutor() {
	}

	public LibroAutorPK getId() {
		return id;
	}

	public void setId(LibroAutorPK id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
