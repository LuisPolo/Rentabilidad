package com.integra.rentabilidad.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuear5 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Cuear5() {
		super();
		this.saldoAfectoObl = 0.0;
		this.saldoAfectoVCF = 0.0;
		this.saldoAfectoVSF = 0.0;
		this.saldoInafectoObl = 0.0;
		this.saldoInafectoVCF = 0.0;
		this.saldoInafectoVSF = 0.0;
		this.saldoObl = 0.0;
		this.saldoVCF = 0.0;
		this.saldoVSF = 0.0;
		this.fondoObl = "";
		this.fondoVcf = "";
		this.fondoVsf = "";
		this.cuentaObl = "";
		this.cuentaVCF = "";
		this.cuentaVSF = "";
		this.subCuentaObl = "";
		this.subCuentaVCF = "";
		this.SubCuentaVSF = "";
	}
   
	@Id
	@Column(name = "CUSPP")
	private String cuspp;
	@Column(name = "CUENTA_OBL")
	private String cuentaObl;
	@Column(name = "SUB_CUENTA_OBL")
	private String subCuentaObl;
	@Column(name = "FONDO_OBL")
	private String fondoObl;
	@Column(name = "SALDO_OBL")
	private Double saldoObl;
	@Column(name = "SALDO_INAFEC_OBL")
	private Double saldoInafectoObl;
	@Column(name = "SALDO_AFEC_OBL")
	private Double saldoAfectoObl;
	@Column(name = "CUENTA_VCF")
	private String cuentaVCF;
	@Column(name = "SUB_CUENTA_VCF")
	private String subCuentaVCF;
	@Column(name = "FONDO_VCF")
	private String fondoVcf;
	@Column(name = "SALDO_VCF")
	private Double saldoVCF;
	@Column(name = "SALDO_INAFEC_VCF")
	private Double saldoInafectoVCF;
	@Column(name = "SALDO_AFEC_VCF")
	private Double saldoAfectoVCF;
	@Column(name = "CUENTA_VSF")
	private String cuentaVSF;
	@Column(name = "SUB_CUENTA_VSF")
	private String SubCuentaVSF;
	@Column(name = "FONDO_VSF")
	private String fondoVsf;
	@Column(name = "SALDO_VSF")
	private Double saldoVSF;
	@Column(name = "SALDO_INAFEC_VSF")
	private Double saldoInafectoVSF;
	@Column(name = "SALDO_AFEC_VSF")
	private Double saldoAfectoVSF;

	public String getCuspp() {
		return cuspp;
	}
	public void setCuspp(String cuspp) {
		this.cuspp = cuspp;
	}
	public String getCuentaObl() {
		return cuentaObl;
	}
	public void setCuentaObl(String cuentaObl) {
		this.cuentaObl = cuentaObl;
	}
	public String getSubCuentaObl() {
		return subCuentaObl;
	}
	public void setSubCuentaObl(String subCuentaObl) {
		this.subCuentaObl = subCuentaObl;
	}
	public String getFondoObl() {
		return fondoObl;
	}
	public void setFondoObl(String fondoObl) {
		this.fondoObl = fondoObl;
	}
	public Double getSaldoObl() {
		return saldoObl;
	}
	public void setSaldoObl(Double saldoObl) {
		this.saldoObl = saldoObl;
	}
	public Double getSaldoInafectoObl() {
		return saldoInafectoObl;
	}
	public void setSaldoInafectoObl(Double saldoInafectoObl) {
		this.saldoInafectoObl = saldoInafectoObl;
	}
	public Double getSaldoAfectoObl() {
		return saldoAfectoObl;
	}
	public void setSaldoAfectoObl(Double saldoAfectoObl) {
		this.saldoAfectoObl = saldoAfectoObl;
	}
	public String getCuentaVCF() {
		return cuentaVCF;
	}
	public void setCuentaVCF(String cuentaVCF) {
		this.cuentaVCF = cuentaVCF;
	}
	public String getSubCuentaVCF() {
		return subCuentaVCF;
	}
	public void setSubCuentaVCF(String subCuentaVCF) {
		this.subCuentaVCF = subCuentaVCF;
	}
	public String getFondoVcf() {
		return fondoVcf;
	}
	public void setFondoVcf(String fondoVcf) {
		this.fondoVcf = fondoVcf;
	}
	public Double getSaldoVCF() {
		return saldoVCF;
	}
	public void setSaldoVCF(Double saldoVCF) {
		this.saldoVCF = saldoVCF;
	}
	public Double getSaldoInafectoVCF() {
		return saldoInafectoVCF;
	}
	public void setSaldoInafectoVCF(Double saldoInafectoVCF) {
		this.saldoInafectoVCF = saldoInafectoVCF;
	}
	public Double getSaldoAfectoVCF() {
		return saldoAfectoVCF;
	}
	public void setSaldoAfectoVCF(Double saldoAfectoVCF) {
		this.saldoAfectoVCF = saldoAfectoVCF;
	}
	public String getCuentaVSF() {
		return cuentaVSF;
	}
	public void setCuentaVSF(String cuentaVSF) {
		this.cuentaVSF = cuentaVSF;
	}
	public String getSubCuentaVSF() {
		return SubCuentaVSF;
	}
	public void setSubCuentaVSF(String subCuentaVSF) {
		SubCuentaVSF = subCuentaVSF;
	}
	public String getFondoVsf() {
		return fondoVsf;
	}
	public void setFondoVsf(String fondoVsf) {
		this.fondoVsf = fondoVsf;
	}
	public Double getSaldoVSF() {
		return saldoVSF;
	}
	public void setSaldoVSF(Double saldoVSF) {
		this.saldoVSF = saldoVSF;
	}
	public Double getSaldoInafectoVSF() {
		return saldoInafectoVSF;
	}
	public void setSaldoInafectoVSF(Double saldoInafectoVSF) {
		this.saldoInafectoVSF = saldoInafectoVSF;
	}
	public Double getSaldoAfectoVSF() {
		return saldoAfectoVSF;
	}
	public void setSaldoAfectoVSF(Double saldoAfectoVSF) {
		this.saldoAfectoVSF = saldoAfectoVSF;
	}
}
