package com.biblioteca.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LibroAutorPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "lau_autor")
	private Integer autor;

	@Column(name = "lau_libro")
	private Integer libro;

	public LibroAutorPK() {
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public Integer getLibro() {
		return libro;
	}

	public void setLibro(Integer libro) {
		this.libro = libro;
	}

}
