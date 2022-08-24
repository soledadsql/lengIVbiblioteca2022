package com.biblioteca.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libros_autores")
public class LibroAutor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	@Column(name="lau_libro")
	private Integer codLibro;
	
	@Column(name="lau_autor")
	private Integer codAutor;

	public LibroAutor() {
		super();
	}

	public Integer getCodLibro() {
		return codLibro;
	}

	public void setCodLibro(Integer codLibro) {
		this.codLibro = codLibro;
	}

	public Integer getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(Integer codAutor) {
		this.codAutor = codAutor;
	}
	
	
}
