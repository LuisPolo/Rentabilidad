package com.integra.rentabilidad.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Etrarc implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Etrarc() {
		super();
	}
   
	@Id
	@Column(name = "CUSPP")
	private String cuspp;
	@Column(name = "MAX_DEVENGUE")
	private String maxDevengue;
	@Column(name = "APORTE_OBL_1")
	private Double aporteObl_1;
	@Column(name = "APORTE_OBL_2")
	private Double aporteObl_2;
	@Column(name = "APORTE_OBL_3")
	private Double aporteObl_3;
	@Column(name = "CARGO_OBL_1")
	private Double cargoObl_1;
	@Column(name = "CARGO_OBL_2")
	private Double cargoObl_2;
	@Column(name = "CARGO_OBL_3")
	private Double cargoObl_3;
	@Column(name = "APORTE_VCF_1")
	private Double aporteVcf_1;
	@Column(name = "APORTE_VCF_2")
	private Double aporteVcf_2;
	@Column(name = "APORTE_VCF_3")
	private Double aporteVcf_3;
	@Column(name = "CARGO_VCF_1")
	private Double cargoVcf_1;
	@Column(name = "CARGO_VCF_2")
	private Double cargoVcf_2;
	@Column(name = "CARGO_VCF_3")
	private Double cargoVcf_3;
	@Column(name = "FLG_CARGA_RENTA")
	private String flagCargaRenta;

	public String getCuspp() {
		return cuspp;
	}
	public void setCuspp(String cuspp) {
		this.cuspp = cuspp;
	}
	public String getMaxDevengue() {
		return maxDevengue;
	}
	public void setMaxDevengue(String maxDevengue) {
		this.maxDevengue = maxDevengue;
	}
	public Double getAporteObl_1() {
		return aporteObl_1;
	}
	public void setAporteObl_1(Double aporteObl_1) {
		this.aporteObl_1 = aporteObl_1;
	}
	public Double getAporteObl_2() {
		return aporteObl_2;
	}
	public void setAporteObl_2(Double aporteObl_2) {
		this.aporteObl_2 = aporteObl_2;
	}
	public Double getAporteObl_3() {
		return aporteObl_3;
	}
	public void setAporteObl_3(Double aporteObl_3) {
		this.aporteObl_3 = aporteObl_3;
	}
	public Double getCargoObl_1() {
		return cargoObl_1;
	}
	public void setCargoObl_1(Double cargoObl_1) {
		this.cargoObl_1 = cargoObl_1;
	}
	public Double getCargoObl_2() {
		return cargoObl_2;
	}
	public void setCargoObl_2(Double cargoObl_2) {
		this.cargoObl_2 = cargoObl_2;
	}
	public Double getCargoObl_3() {
		return cargoObl_3;
	}
	public void setCargoObl_3(Double cargoObl_3) {
		this.cargoObl_3 = cargoObl_3;
	}
	public Double getAporteVcf_1() {
		return aporteVcf_1;
	}
	public void setAporteVcf_1(Double aporteVcf_1) {
		this.aporteVcf_1 = aporteVcf_1;
	}
	public Double getAporteVcf_2() {
		return aporteVcf_2;
	}
	public void setAporteVcf_2(Double aporteVcf_2) {
		this.aporteVcf_2 = aporteVcf_2;
	}
	public Double getAporteVcf_3() {
		return aporteVcf_3;
	}
	public void setAporteVcf_3(Double aporteVcf_3) {
		this.aporteVcf_3 = aporteVcf_3;
	}
	public Double getCargoVcf_1() {
		return cargoVcf_1;
	}
	public void setCargoVcf_1(Double cargoVcf_1) {
		this.cargoVcf_1 = cargoVcf_1;
	}
	public Double getCargoVcf_2() {
		return cargoVcf_2;
	}
	public void setCargoVcf_2(Double cargoVcf_2) {
		this.cargoVcf_2 = cargoVcf_2;
	}
	public Double getCargoVcf_3() {
		return cargoVcf_3;
	}
	public void setCargoVcf_3(Double cargoVcf_3) {
		this.cargoVcf_3 = cargoVcf_3;
	}
	public String getFlagCargaRenta() {
		return flagCargaRenta;
	}
	public void setFlagCargaRenta(String flagCargaRenta) {
		this.flagCargaRenta = flagCargaRenta;
	}
	
}
