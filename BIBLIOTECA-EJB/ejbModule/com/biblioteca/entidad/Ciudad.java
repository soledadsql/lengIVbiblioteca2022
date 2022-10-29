package com.biblioteca.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // poner asi cuando es serial
	@Column(name = "ciu_codigo")
	private Integer codigo;

	@Column(name = "ciu_descripcion")
	private String descripcion;

	// @OneToMany //siempre es list, porque many devuelve mucho
//	private List<Autor> autores;

	public Ciudad() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
