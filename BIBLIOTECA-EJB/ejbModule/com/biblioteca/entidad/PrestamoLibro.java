package com.biblioteca.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prestamos_libros")
public class PrestamoLibro {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	@Column(name="pli_secuencia")
	private Integer codigo;
	
	@Column(name="pli_prestamo")
	private Integer codPrestamo;
	
	@Column(name="pli_libro")
	private Integer codLibro;
	
	@Column(name="pli_estado")
	private Integer estado;
	
	@Column(name="pli_dias")
	private Integer dias;
	
	@Column(name="pli_valor")
	private double valor;
	
	@Column(name="pli_fecha_devolucion")
	private Date fechaDevolucion;

	public PrestamoLibro() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodPrestamo() {
		return codPrestamo;
	}

	public void setCodPrestamo(Integer codPrestamo) {
		this.codPrestamo = codPrestamo;
	}

	public Integer getCodLibro() {
		return codLibro;
	}

	public void setCodLibro(Integer codLibro) {
		this.codLibro = codLibro;
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

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
}
