package com.biblioteca.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prestamos")
public class Prestamo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	@Column(name="pre_numero")
	private Integer codigo;
	
	@Column(name="pre_cliente")
	private Integer codCliente;
	
	@Column(name="pre_usuario")
	private Integer codUsuario;
	
	@Column(name="pre_fecha")
	private Date fecha;
	
	@Column(name="pre_obs")
	private String obs;
	
	@Column(name="pre_situacion")
	private Integer situacion;
	
	@Column(name="pre_total")
	private double total;

	public Prestamo() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getSituacion() {
		return situacion;
	}

	public void setSituacion(Integer situacion) {
		this.situacion = situacion;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
