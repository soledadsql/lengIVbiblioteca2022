package com.biblioteca.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
@Table(name = "prestamos_libros")
public class PrestamoLibro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pli_secuencia")
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "pli_prestamo")
	private Prestamo prestamo;

	@ManyToOne
	@JoinColumn(name = "pli_libro")
	private Libro libro;

	@Column(name = "pli_estado")
	private Integer estado;

	@Column(name = "pli_dias")
	private Integer dias;

	@Column(name = "pli_valor")
	private double valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "pli_fecha_devolucion")
	private Date fecha_devolucion;

	public PrestamoLibro() {
		prestamo = new Prestamo();
		libro = new Libro();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

}
