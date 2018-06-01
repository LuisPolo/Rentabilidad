package com.integra.rentabilidad.entidades;

public class MovimientosJSON {
	
	private String fechaMovimiento;
	private double valor;
	private double cuotas;
	private String signo;
	private String codigoExtracto;
	private String periodo;
	private String fechaPago;
	private String ruc;
	private String razonSocial;
	private String motivo;
	private String descripcion;
	private String flagEECC;
	
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getCuotas() {
		return cuotas;
	}
	public void setCuotas(double cuotas) {
		this.cuotas = cuotas;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public String getCodigoExtracto() {
		return codigoExtracto;
	}
	public void setCodigoExtracto(String codigoExtracto) {
		this.codigoExtracto = codigoExtracto;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getMotivo() {
		return motivo;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFlagEECC() {
		return flagEECC;
	}
	public void setFlagEECC(String flagEECC) {
		this.flagEECC = flagEECC;
	}
}
