package com.integra.rentabilidad.entidades;

public class ComisionFlujoJSON {

	private String periodoComision;
	private double montoComisionADM;
	private double montoSeguro;
	
	public String getPeriodoComision() {
		return periodoComision;
	}
	public void setPeriodoComision(String periodoComision) {
		this.periodoComision = periodoComision;
	}
	public double getMontoComisionADM() {
		return montoComisionADM;
	}
	public void setMontoComisionADM(double montoComisionADM) {
		this.montoComisionADM = montoComisionADM;
	}
	public double getMontoSeguro() {
		return montoSeguro;
	}
	public void setMontoSeguro(double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}
	
}
