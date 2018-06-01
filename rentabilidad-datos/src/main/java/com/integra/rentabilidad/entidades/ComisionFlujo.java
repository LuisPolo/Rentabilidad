package com.integra.rentabilidad.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ComisionFlujo
 *
 */
@Entity
public class ComisionFlujo implements Serializable {

	private static final long serialVersionUID = 1L;

	public ComisionFlujo() {
		super();
	}
	
	@Id
	@Column(name = "ORDEN")
	private String orden;
	@Column(name = "MOVNUM")
	private String cuspp;
	@Column(name = "MOVPER")
	private String periodo;
	@Column(name = "MOVFEC")
	private String fecha;
	@Column(name = "COF01")
	private double comision;
	@Column(name = "COF02")
	private double interesComision;
	@Column(name = "SEG01")
	private double seguro;
	@Column(name = "SEG02")
	private double interesSeguro;

	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getCuspp() {
		return cuspp;
	}
	public void setCuspp(String cuspp) {
		this.cuspp = cuspp;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public double getInteresComision() {
		return interesComision;
	}
	public void setInteresComision(double interesComision) {
		this.interesComision = interesComision;
	}
	public double getSeguro() {
		return seguro;
	}
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}
	public double getInteresSeguro() {
		return interesSeguro;
	}
	public void setInteresSeguro(double interesSeguro) {
		this.interesSeguro = interesSeguro;
	}
   
}
