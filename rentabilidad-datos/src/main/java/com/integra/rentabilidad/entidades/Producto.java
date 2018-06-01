package com.integra.rentabilidad.entidades;

import java.util.List;

/**
 * Entity implementation class for Entity: Producto
 *
 */

public class Producto {

	public Producto() {
		super();
		
		/*this.tipoFondo = "";
		this.rentabilidad = 0;
		this.rentabilidadPeriodo = 0;
		this.saldoCICActual = 0;
		this.saldoCICCuotas = 0;
		this.totalAcreditaciones = 0;
		this.totalCargos = 0;
		this.saldoAfecto = 0;
		this.saldoInafecto = 0;
		this.interesLegal = 0;
		this.flagError = "";*/
	}
	
	private String tipoFondo;
    private Double rentabilidad;
    private Double rentabilidadPeriodo;
    private Double saldoCICActual;
    private Double saldoCICCuotas;
    private Double totalAcreditaciones;
    private Double totalCargos;
    private Double saldoAfecto;
    private Double saldoInafecto;
    private Double interesLegal;
    private String flagError;
    private List<MovimientosJSON> movimientos;
    private List<ComisionFlujoJSON> comisionFlujo;
    private List<ComisionSaldoJSON> comisionSaldo;
    private ComisionMovimiento comisiones;
    
	public String getTipoFondo() {
		return tipoFondo;
	}
	public void setTipoFondo(String tipoFondo) {
		this.tipoFondo = tipoFondo;
	}
	public Double getRentabilidad() {
		return rentabilidad;
	}
	public void setRentabilidad(Double rentabilidadSPP) {
		this.rentabilidad = rentabilidadSPP;
	}
	public Double getRentabilidadPeriodo() {
		return rentabilidadPeriodo;
	}
	public void setRentabilidadPeriodo(Double rentabilidadPeriodo) {
		this.rentabilidadPeriodo = rentabilidadPeriodo;
	}
	public Double getSaldoCICActual() {
		return saldoCICActual;
	}
	public void setSaldoCICActual(Double saldoCICActual) {
		this.saldoCICActual = saldoCICActual;
	}
	public Double getSaldoCICCuotas() {
		return saldoCICCuotas;
	}
	public void setSaldoCICCuotas(Double saldoCICCuotas) {
		this.saldoCICCuotas = saldoCICCuotas;
	}
	public Double getTotalAcreditaciones() {
		return totalAcreditaciones;
	}
	public void setTotalAcreditaciones(Double totalAcreditaciones) {
		this.totalAcreditaciones = totalAcreditaciones;
	}
	public Double getTotalCargos() {
		return totalCargos;
	}
	public void setTotalCargos(Double totalCargos) {
		this.totalCargos = totalCargos;
	}
	public Double getSaldoAfecto() {
		return saldoAfecto;
	}
	public void setSaldoAfecto(Double saldoAfecto) {
		this.saldoAfecto = saldoAfecto;
	}
	public Double getSaldoInafecto() {
		return saldoInafecto;
	}
	public void setSaldoInafecto(Double saldoInafecto) {
		this.saldoInafecto = saldoInafecto;
	}
	public List<MovimientosJSON> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<MovimientosJSON> movimientos) {
		this.movimientos = movimientos;
	}
	public List<ComisionFlujoJSON> getComisionFlujo() {
		return comisionFlujo;
	}
	public void setComisionFlujo(List<ComisionFlujoJSON> comisionFlujo) {
		this.comisionFlujo = comisionFlujo;
	}
	public List<ComisionSaldoJSON> getComisionSaldo() {
		return comisionSaldo;
	}
	public void setComisionSaldo(List<ComisionSaldoJSON> comisionSaldo) {
		this.comisionSaldo = comisionSaldo;
	}
	public double getInteresLegal() {
		return interesLegal;
	}
	public void setInteresLegal(double interesLegal) {
		this.interesLegal = interesLegal;
	}
	public String getFlagError() {
		return flagError;
	}
	public void setFlagError(String flagError) {
		this.flagError = flagError;
	}
	public ComisionMovimiento getComisiones() {
		return comisiones;
	}
	public void setComisiones(ComisionMovimiento comisiones) {
		this.comisiones = comisiones;
	}
	
	/*private String cuspp;
	//OBLIGATORIO
	private String tipoFondo_OBL;
    private double rentabilidadSPP_OBL;
    private double saldoCICActual_OBL;
    private double saldoCICCuotas_OBL;
    private double totalAcreditaciones_OBL;
    private double totalCargos_OBL;
    private double saldoAfecto_OBL;
    private double saldoInafecto_OBL;
	//VCF
	private String tipoFondo_VCF;
    private double rentabilidadSPP_VCF;
    private double saldoCICActual_VCF;
    private double saldoCICCuotas_VCF;
    private double totalAcreditaciones_VCF;
    private double totalCargos_VCF;
    private double saldoAfecto_VCF;
    private double saldoInafecto_VCF;
	//VSF
	private String tipoFondo_VSF;
	private double rentabilidadSPP_VSF;
	private double saldoCICActual_VSF;
	private double saldoCICCuotas_VSF;
	private double totalAcreditaciones_VSF;
	private double totalCargos_VSF;
	private double saldoAfecto_VSF;
	private double saldoInafecto_VSF;
*/
}
