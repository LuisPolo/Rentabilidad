package com.integra.rentabilidad.entidades;

import java.math.BigDecimal;

public class Comision {
	private BigDecimal comisionSaldoSPP;// Fija Cargos
	private BigDecimal comisionRIASPP;// Abonos
	private BigDecimal comisionSaldo;
	private BigDecimal comisionMixtaRIA;
	private BigDecimal comisionFlujoRIA;
	private BigDecimal interesSaldo;
	private BigDecimal interesMixtaRIA;
	private BigDecimal interesFlujoRIA;
	private BigDecimal seguroNominal;
	private BigDecimal seguroInteres;
	
	public BigDecimal getComisionSaldoSPP() {
		return comisionSaldoSPP;
	}
	public void setComisionSaldoSPP(BigDecimal comisionSaldoSPP) {
		this.comisionSaldoSPP = comisionSaldoSPP;
	}
	public BigDecimal getComisionRIASPP() {
		return comisionRIASPP;
	}
	public void setComisionRIASPP(BigDecimal comisionRIASPP) {
		this.comisionRIASPP = comisionRIASPP;
	}
	public BigDecimal getComisionSaldo() {
		return comisionSaldo;
	}
	public void setComisionSaldo(BigDecimal comisionSaldo) {
		this.comisionSaldo = comisionSaldo;
	}
	public BigDecimal getComisionMixtaRIA() {
		return comisionMixtaRIA;
	}
	public void setComisionMixtaRIA(BigDecimal comisionMixtaRIA) {
		this.comisionMixtaRIA = comisionMixtaRIA;
	}
	public BigDecimal getComisionFlujoRIA() {
		return comisionFlujoRIA;
	}
	public void setComisionFlujoRIA(BigDecimal comisionFlujoRIA) {
		this.comisionFlujoRIA = comisionFlujoRIA;
	}
	public BigDecimal getSeguroNominal() {
		return seguroNominal;
	}
	public void setSeguroNominal(BigDecimal seguroNominal) {
		this.seguroNominal = seguroNominal;
	}
	public BigDecimal getSeguroInteres() {
		return seguroInteres;
	}
	public void setSeguroInteres(BigDecimal seguroInteres) {
		this.seguroInteres = seguroInteres;
	}
	public BigDecimal getInteresSaldo() {
		return interesSaldo;
	}
	public void setInteresSaldo(BigDecimal interesSaldo) {
		this.interesSaldo = interesSaldo;
	}
	public BigDecimal getInteresMixtaRIA() {
		return interesMixtaRIA;
	}
	public void setInteresMixtaRIA(BigDecimal interesMixtaRIA) {
		this.interesMixtaRIA = interesMixtaRIA;
	}
	public BigDecimal getInteresFlujoRIA() {
		return interesFlujoRIA;
	}
	public void setInteresFlujoRIA(BigDecimal interesFlujoRIA) {
		this.interesFlujoRIA = interesFlujoRIA;
	}
}
