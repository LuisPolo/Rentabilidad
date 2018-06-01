package com.integra.rentabilidad.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ifdar7
 *
 */
@Entity
public class Ifdar7 implements Serializable {

	private static final long serialVersionUID = 1L;

	public Ifdar7() {
		super();
	}
	
	@Id
	@Column(name = "ORDEN")
	private String orden;
	@Column(name = "IFDTIP")
	private String fondo;
	@Column(name = "IFDF10")
	private String fecha;
	@Column(name = "IFDVA5")
	private double valorCuota;
	@Column(name = "TEXTO")
	private String texto;

	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getFondo() {
		return fondo;
	}
	public void setFondo(String fondo) {
		this.fondo = fondo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
