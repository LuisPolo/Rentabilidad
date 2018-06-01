package com.integra.rentabilidad.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rentabilidad implements Serializable {

	private static final long serialVersionUID = 1L;

	public Rentabilidad() {
		super();
		
		this.abono_1 = 0.0;
		this.abono_2 = 0.0;
		this.abono_3 = 0.0;
		this.abono_4 = 0.0;
		this.abono_5 = 0.0;
		this.abono_6 = 0.0;
		this.abono_7 = 0.0;
		this.abono_8 = 0.0;
		this.abono_9 = 0.0;
		this.abono_10 = 0.0;
		this.abono_11 = 0.0;
		this.abono_12 = 0.0;
		this.abono_13 = 0.0;
		this.abono_14 = 0.0;
		this.abono_15 = 0.0;
		this.abono_16 = 0.0;
		this.abono_17 = 0.0;
		this.abono_18 = 0.0;
		this.cargo_1 = 0.0;
		this.cargo_2 = 0.0;
		this.cargo_3 = 0.0;
		this.cargo_4 = 0.0;
		this.cargo_5 = 0.0;
		this.cargo_6 = 0.0;
		this.cargo_7 = 0.0;
		this.cargo_8 = 0.0;
		this.cargo_9 = 0.0;
		this.cargo_10 = 0.0;
		this.cargo_11 = 0.0;
		this.cargo_12 = 0.0;
		this.cargo_13 = 0.0;
		this.cargo_14 = 0.0;
		this.cargo_15 = 0.0;
		this.cargo_16 = 0.0;
		this.cargo_17 = 0.0;
		this.cargo_18 = 0.0;
		this.saldoAfecto_OBL = 0.0;
		this.saldoInafecto_OBL = 0.0;
		this.saldoAfecto_VCF = 0.0;
		this.saldoInafecto_VCF = 0.0;
		this.saldoAfecto_VSF = 0.0;
		this.saldoInafecto_VSF = 0.0;
		this.comisionFlujoObl = 0.0;
		this.comisionInteresObl = 0.0;
		this.seguroObl = 0.0;
		this.seguroInteresObl = 0.0;
		this.cuotasObl = 0.0;
		this.comisionFlujoVcf = 0.0;
		this.comisionInteresVcf = 0.0;
		this.seguroVcf = 0.0;
		this.seguroInteresVcf = 0.0;
		this.cuotasVcf = 0.0;
		this.cuotasVsf = 0.0;
		// OTXXXXX - Comisiones INI
		this.comiSaldoAbonoOBL = new BigDecimal("0.00");
		this.comiMixRiaAbonoOBL = new BigDecimal("0.00");
		this.comiFluRiaAbonoOBL = new BigDecimal("0.00");
		//this.comiSaldoCargoOBL = new BigDecimal("0.00");
		this.comiMixRiaCargoOBL = new BigDecimal("0.00");
		this.comiFluRiaCargoOBL = new BigDecimal("0.00");
		this.comiSaldoAbonoVCF = new BigDecimal("0.00");
		this.comiSaldoAbonoVSF = new BigDecimal("0.00");
		//this.comiMixRiaAbonoVCF = new BigDecimal("0.00");
		//this.comiFluRiaAbonoVCF = new BigDecimal("0.00");
		//this.comiSaldoCargoVCF = new BigDecimal("0.00");
		//this.comiMixRiaCargoVCF = new BigDecimal("0.00");
		//this.comiFluRiaCargoVCF = new BigDecimal("0.00");
		this.seguNominAbonoOBL = new BigDecimal("0.00");
		this.seguIntereAbonoOBL = new BigDecimal("0.00");
		this.seguNominCargoOBL = new BigDecimal("0.00");
		this.seguIntereCargoOBL = new BigDecimal("0.00");
		//this.seguNominAbonoVCF = new BigDecimal("0.00");
		//this.seguIntereAbonoVCF = new BigDecimal("0.00");
		//this.seguNominCargoVCF = new BigDecimal("0.00");
		//this.seguIntereCargoVCF = new BigDecimal("0.00");
		//this.inteSaldoAbonoOBL = new BigDecimal("0.00");
		this.inteMixRiaAbonoOBL = new BigDecimal("0.00");
		this.inteFluRiaAbonoOBL = new BigDecimal("0.00");
		//this.inteSaldoCargoOBL = new BigDecimal("0.00");
		this.inteMixRiaCargoOBL = new BigDecimal("0.00");
		this.inteFluRiaCargoOBL = new BigDecimal("0.00");
		//this.inteSaldoAbonoVCF = new BigDecimal("0.00");
		//this.inteMixRiaAbonoVCF = new BigDecimal("0.00");
		//this.inteFluRiaAbonoVCF = new BigDecimal("0.00");
		//this.inteSaldoCargoVCF = new BigDecimal("0.00");
		//this.inteMixRiaCargoVCF = new BigDecimal("0.00");
		//this.inteFluRiaCargoVCF = new BigDecimal("0.00");
		// OTXXXXX - Comisiones FIN
	}
	
	@Id
	@Column(name = "ORDEN")
	private String orden;
	@Column(name = "PERIODO")
	private String periodo;
	@Column(name = "CUSPP")
	private String cuspp;
	@Column(name = "ABONO_1")
	private Double abono_1;
	@Column(name = "ABONO_2")
	private Double abono_2;
	@Column(name = "ABONO_3")
	private Double abono_3;
	@Column(name = "ABONO_4")
	private Double abono_4;
	@Column(name = "ABONO_5")
	private Double abono_5;
	@Column(name = "ABONO_6")
	private Double abono_6;
	@Column(name = "CARGO_1")
	private Double cargo_1;
	@Column(name = "CARGO_2")
	private Double cargo_2;
	@Column(name = "CARGO_3")
	private Double cargo_3;
	@Column(name = "CARGO_4")
	private Double cargo_4;
	@Column(name = "CARGO_5")
	private Double cargo_5;
	@Column(name = "CARGO_6")
	private Double cargo_6;
	@Column(name = "COMI_FLUJO_OBL")
	private Double comisionFlujoObl;
	@Column(name = "COMI_INTERES_OBL")
	private Double comisionInteresObl;
	@Column(name = "SEGURO_OBL")
	private Double seguroObl;
	@Column(name = "SEGURO_INTERES_OBL")
	private Double seguroInteresObl;
	@Column(name = "FONDO_OBL")
	private String fondo_OBL;
	@Column(name = "SALDO_AFEC_OBL")
	private Double saldoAfecto_OBL;
	@Column(name = "SALDO_INAFEC_OBL")
	private Double saldoInafecto_OBL;
	@Column(name = "CUOTAS_OBL")
	private double cuotasObl;
	@Column(name = "ABONO_7")
	private Double abono_7;
	@Column(name = "ABONO_8")
	private Double abono_8;
	@Column(name = "ABONO_9")
	private Double abono_9;
	@Column(name = "ABONO_10")
	private Double abono_10;
	@Column(name = "ABONO_11")
	private Double abono_11;
	@Column(name = "ABONO_12")
	private Double abono_12;
	@Column(name = "CARGO_7")
	private Double cargo_7;
	@Column(name = "CARGO_8")
	private Double cargo_8;
	@Column(name = "CARGO_9")
	private Double cargo_9;
	@Column(name = "CARGO_10")
	private Double cargo_10;
	@Column(name = "CARGO_11")
	private Double cargo_11;
	@Column(name = "CARGO_12")
	private Double cargo_12;
	@Column(name = "COMI_FLUJO_VCF")
	private Double comisionFlujoVcf;
	@Column(name = "COMI_INTERES_VCF")
	private Double comisionInteresVcf;
	@Column(name = "SEGURO_VCF")
	private Double seguroVcf;
	@Column(name = "SEGURO_INTERES_VCF")
	private Double seguroInteresVcf;
	@Column(name = "FONDO_VCF")
	private String fondo_VCF;
	@Column(name = "SALDO_AFEC_VCF")
	private Double saldoAfecto_VCF;
	@Column(name = "SALDO_INAFEC_VCF")
	private Double saldoInafecto_VCF;
	@Column(name = "CUOTAS_VCF")
	private double cuotasVcf;
	@Column(name = "ABONO_13")
	private Double abono_13;
	@Column(name = "ABONO_14")
	private Double abono_14;
	@Column(name = "ABONO_15")
	private Double abono_15;
	@Column(name = "ABONO_16")
	private Double abono_16;
	@Column(name = "ABONO_17")
	private Double abono_17;
	@Column(name = "ABONO_18")
	private Double abono_18;
	@Column(name = "CARGO_13")
	private Double cargo_13;
	@Column(name = "CARGO_14")
	private Double cargo_14;
	@Column(name = "CARGO_15")
	private Double cargo_15;
	@Column(name = "CARGO_16")
	private Double cargo_16;
	@Column(name = "CARGO_17")
	private Double cargo_17;
	@Column(name = "CARGO_18")
	private Double cargo_18;
	@Column(name = "FONDO_VSF")
	private String fondo_VSF;
	@Column(name = "SALDO_AFEC_VSF")
	private Double saldoAfecto_VSF;
	@Column(name = "SALDO_INAFEC_VSF")
	private Double saldoInafecto_VSF;
	@Column(name = "CUOTAS_VSF")
	private double cuotasVsf;
	@Column(name = "FLG_ERROR_OBL")
	private String flgErrorObl;
	@Column(name = "FLG_ERROR_VCF")
	private String flgErrorVcf;
	@Column(name = "FLG_ERROR_VSF")
	private String flgErrorVsf;
	@Column(name = "VAL_CUO_OBL")
	private Double valorCuotaObl;
	@Column(name = "VAL_CUO_VCF")
	private Double valorCuotaVcf;
	@Column(name = "VAL_CUO_VSF")
	private Double valorCuotaVsf;

	// OTXXXXX - COMISIONES INI
	@Column(name = "COMI_SAL_ABO_OBL")
	private BigDecimal comiSaldoAbonoOBL;
	@Column(name = "COMI_MIX_ABO_OBL")
	private BigDecimal comiMixRiaAbonoOBL;
	@Column(name = "COMI_FLU_ABO_OBL")
	private BigDecimal comiFluRiaAbonoOBL;
	//@Column(name = "COMI_SAL_CAR_OBL")
	//private BigDecimal comiSaldoCargoOBL;
	@Column(name = "COMI_MIX_CAR_OBL")
	private BigDecimal comiMixRiaCargoOBL;
	@Column(name = "COMI_FLU_CAR_OBL")
	private BigDecimal comiFluRiaCargoOBL;
	@Column(name = "COMI_SAL_ABO_VCF")
	private BigDecimal comiSaldoAbonoVCF;
	@Column(name = "COMI_SAL_ABO_VSF")
	private BigDecimal comiSaldoAbonoVSF;
	/*@Column(name = "COMI_MIX_ABO_VCF")
	private BigDecimal comiMixRiaAbonoVCF;
	@Column(name = "COMI_FLU_ABO_VCF")
	private BigDecimal comiFluRiaAbonoVCF;
	@Column(name = "COMI_SAL_CAR_VCF")
	private BigDecimal comiSaldoCargoVCF;
	@Column(name = "COMI_MIX_CAR_VCF")
	private BigDecimal comiMixRiaCargoVCF;
	@Column(name = "COMI_FLU_CAR_VCF")
	private BigDecimal comiFluRiaCargoVCF;*/
	@Column(name = "SEG_NOMI_ABO_OBL")
	private BigDecimal seguNominAbonoOBL;
	@Column(name = "SEG_INTE_ABO_OBL")
	private BigDecimal seguIntereAbonoOBL;
	@Column(name = "SEG_NOMI_CAR_OBL")
	private BigDecimal seguNominCargoOBL;
	@Column(name = "SEG_INTE_CAR_OBL")
	private BigDecimal seguIntereCargoOBL;
	/*@Column(name = "SEG_NOMI_ABO_VCF")
	private BigDecimal seguNominAbonoVCF;
	@Column(name = "SEG_INTE_ABO_VCF")
	private BigDecimal seguIntereAbonoVCF;
	@Column(name = "SEG_NOMI_CAR_VCF")
	private BigDecimal seguNominCargoVCF;
	@Column(name = "SEG_INTE_CAR_VCF")
	private BigDecimal seguIntereCargoVCF;*/
	//@Column(name = "INT_SAL_ABO_OBL")
	//private BigDecimal inteSaldoAbonoOBL;
	@Column(name = "INT_MIX_ABO_OBL")
	private BigDecimal inteMixRiaAbonoOBL;
	@Column(name = "INT_FLU_ABO_OBL")
	private BigDecimal inteFluRiaAbonoOBL;
	//@Column(name = "INT_SAL_CAR_OBL")
	//private BigDecimal inteSaldoCargoOBL;
	@Column(name = "INT_MIX_CAR_OBL")
	private BigDecimal inteMixRiaCargoOBL;
	@Column(name = "INT_FLU_CAR_OBL")
	private BigDecimal inteFluRiaCargoOBL;
	//@Column(name = "INT_SAL_ABO_VCF")
	//private BigDecimal inteSaldoAbonoVCF;
	/*@Column(name = "INT_MIX_ABO_VCF")
	private BigDecimal inteMixRiaAbonoVCF;
	@Column(name = "INT_FLU_ABO_VCF")
	private BigDecimal inteFluRiaAbonoVCF;*/
	//@Column(name = "INT_SAL_CAR_VCF")
	//private BigDecimal inteSaldoCargoVCF;
	/*@Column(name = "INT_MIX_CAR_VCF")
	private BigDecimal inteMixRiaCargoVCF;
	@Column(name = "INT_FLU_CAR_VCF")
	private BigDecimal inteFluRiaCargoVCF;*/
	// OTXXXXX - COMISIONES FIN

	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getCuspp() {
		return cuspp;
	}
	public void setCuspp(String cuspp) {
		this.cuspp = cuspp;
	}
	public Double getAbono_1() {
		return abono_1;
	}
	public void setAbono_1(Double abono_1) {
		this.abono_1 = abono_1;
	}
	public Double getAbono_2() {
		return abono_2;
	}
	public void setAbono_2(Double abono_2) {
		this.abono_2 = abono_2;
	}
	public Double getAbono_3() {
		return abono_3;
	}
	public void setAbono_3(Double abono_3) {
		this.abono_3 = abono_3;
	}
	public Double getAbono_4() {
		return abono_4;
	}
	public void setAbono_4(Double abono_4) {
		this.abono_4 = abono_4;
	}
	public Double getAbono_5() {
		return abono_5;
	}
	public void setAbono_5(Double abono_5) {
		this.abono_5 = abono_5;
	}
	public Double getAbono_6() {
		return abono_6;
	}
	public void setAbono_6(Double abono_6) {
		this.abono_6 = abono_6;
	}
	public Double getCargo_1() {
		return cargo_1;
	}
	public void setCargo_1(Double cargo_1) {
		this.cargo_1 = cargo_1;
	}
	public Double getCargo_2() {
		return cargo_2;
	}
	public void setCargo_2(Double cargo_2) {
		this.cargo_2 = cargo_2;
	}
	public Double getCargo_3() {
		return cargo_3;
	}
	public void setCargo_3(Double cargo_3) {
		this.cargo_3 = cargo_3;
	}
	public Double getCargo_4() {
		return cargo_4;
	}
	public void setCargo_4(Double cargo_4) {
		this.cargo_4 = cargo_4;
	}
	public Double getCargo_5() {
		return cargo_5;
	}
	public void setCargo_5(Double cargo_5) {
		this.cargo_5 = cargo_5;
	}
	public Double getCargo_6() {
		return cargo_6;
	}
	public void setCargo_6(Double cargo_6) {
		this.cargo_6 = cargo_6;
	}
	public String getFondo_OBL() {
		return fondo_OBL;
	}
	public void setFondo_OBL(String fondo_OBL) {
		this.fondo_OBL = fondo_OBL;
	}
	public Double getSaldoAfecto_OBL() {
		return saldoAfecto_OBL;
	}
	public void setSaldoAfecto_OBL(Double saldoAfecto_OBL) {
		this.saldoAfecto_OBL = saldoAfecto_OBL;
	}
	public Double getSaldoInafecto_OBL() {
		return saldoInafecto_OBL;
	}
	public void setSaldoInafecto_OBL(Double saldoInafecto_OBL) {
		this.saldoInafecto_OBL = saldoInafecto_OBL;
	}
	public Double getAbono_7() {
		return abono_7;
	}
	public void setAbono_7(Double abono_7) {
		this.abono_7 = abono_7;
	}
	public Double getAbono_8() {
		return abono_8;
	}
	public void setAbono_8(Double abono_8) {
		this.abono_8 = abono_8;
	}
	public Double getAbono_9() {
		return abono_9;
	}
	public void setAbono_9(Double abono_9) {
		this.abono_9 = abono_9;
	}
	public Double getAbono_10() {
		return abono_10;
	}
	public void setAbono_10(Double abono_10) {
		this.abono_10 = abono_10;
	}
	public Double getAbono_11() {
		return abono_11;
	}
	public void setAbono_11(Double abono_11) {
		this.abono_11 = abono_11;
	}
	public Double getAbono_12() {
		return abono_12;
	}
	public void setAbono_12(Double abono_12) {
		this.abono_12 = abono_12;
	}
	public Double getCargo_7() {
		return cargo_7;
	}
	public void setCargo_7(Double cargo_7) {
		this.cargo_7 = cargo_7;
	}
	public Double getCargo_8() {
		return cargo_8;
	}
	public void setCargo_8(Double cargo_8) {
		this.cargo_8 = cargo_8;
	}
	public Double getCargo_9() {
		return cargo_9;
	}
	public void setCargo_9(Double cargo_9) {
		this.cargo_9 = cargo_9;
	}
	public Double getCargo_10() {
		return cargo_10;
	}
	public void setCargo_10(Double cargo_10) {
		this.cargo_10 = cargo_10;
	}
	public Double getCargo_11() {
		return cargo_11;
	}
	public void setCargo_11(Double cargo_11) {
		this.cargo_11 = cargo_11;
	}
	public Double getCargo_12() {
		return cargo_12;
	}
	public void setCargo_12(Double cargo_12) {
		this.cargo_12 = cargo_12;
	}
	public String getFondo_VCF() {
		return fondo_VCF;
	}
	public void setFondo_VCF(String fondo_VCF) {
		this.fondo_VCF = fondo_VCF;
	}
	public Double getSaldoAfecto_VCF() {
		return saldoAfecto_VCF;
	}
	public void setSaldoAfecto_VCF(Double saldoAfecto_VCF) {
		this.saldoAfecto_VCF = saldoAfecto_VCF;
	}
	public Double getSaldoInafecto_VCF() {
		return saldoInafecto_VCF;
	}
	public void setSaldoInafecto_VCF(Double saldoInafecto_VCF) {
		this.saldoInafecto_VCF = saldoInafecto_VCF;
	}
	public Double getAbono_13() {
		return abono_13;
	}
	public void setAbono_13(Double abono_13) {
		this.abono_13 = abono_13;
	}
	public Double getAbono_14() {
		return abono_14;
	}
	public void setAbono_14(Double abono_14) {
		this.abono_14 = abono_14;
	}
	public Double getAbono_15() {
		return abono_15;
	}
	public void setAbono_15(Double abono_15) {
		this.abono_15 = abono_15;
	}
	public Double getAbono_16() {
		return abono_16;
	}
	public void setAbono_16(Double abono_16) {
		this.abono_16 = abono_16;
	}
	public Double getAbono_17() {
		return abono_17;
	}
	public void setAbono_17(Double abono_17) {
		this.abono_17 = abono_17;
	}
	public Double getAbono_18() {
		return abono_18;
	}
	public void setAbono_18(Double abono_18) {
		this.abono_18 = abono_18;
	}
	public Double getCargo_13() {
		return cargo_13;
	}
	public void setCargo_13(Double cargo_13) {
		this.cargo_13 = cargo_13;
	}
	public Double getCargo_14() {
		return cargo_14;
	}
	public void setCargo_14(Double cargo_14) {
		this.cargo_14 = cargo_14;
	}
	public Double getCargo_15() {
		return cargo_15;
	}
	public void setCargo_15(Double cargo_15) {
		this.cargo_15 = cargo_15;
	}
	public Double getCargo_16() {
		return cargo_16;
	}
	public void setCargo_16(Double cargo_16) {
		this.cargo_16 = cargo_16;
	}
	public Double getCargo_17() {
		return cargo_17;
	}
	public void setCargo_17(Double cargo_17) {
		this.cargo_17 = cargo_17;
	}
	public Double getCargo_18() {
		return cargo_18;
	}
	public void setCargo_18(Double cargo_18) {
		this.cargo_18 = cargo_18;
	}
	public String getFondo_VSF() {
		return fondo_VSF;
	}
	public void setFondo_VSF(String fondo_VSF) {
		this.fondo_VSF = fondo_VSF;
	}
	public Double getSaldoAfecto_VSF() {
		return saldoAfecto_VSF;
	}
	public void setSaldoAfecto_VSF(Double saldoAfecto_VSF) {
		this.saldoAfecto_VSF = saldoAfecto_VSF;
	}
	public Double getSaldoInafecto_VSF() {
		return saldoInafecto_VSF;
	}
	public void setSaldoInafecto_VSF(Double saldoInafecto_VSF) {
		this.saldoInafecto_VSF = saldoInafecto_VSF;
	}
	public String getFlgErrorObl() {
		return flgErrorObl;
	}
	public void setFlgErrorObl(String flgErrorObl) {
		this.flgErrorObl = flgErrorObl;
	}
	public String getFlgErrorVcf() {
		return flgErrorVcf;
	}
	public void setFlgErrorVcf(String flgErrorVcf) {
		this.flgErrorVcf = flgErrorVcf;
	}
	public String getFlgErrorVsf() {
		return flgErrorVsf;
	}
	public void setFlgErrorVsf(String flgErrorVsf) {
		this.flgErrorVsf = flgErrorVsf;
	}
	public Double getComisionFlujoObl() {
		return comisionFlujoObl;
	}
	public void setComisionFlujoObl(Double comisionFlujoObl) {
		this.comisionFlujoObl = comisionFlujoObl;
	}
	public Double getComisionInteresObl() {
		return comisionInteresObl;
	}
	public void setComisionInteresObl(Double comisionInteresObl) {
		this.comisionInteresObl = comisionInteresObl;
	}
	public Double getSeguroObl() {
		return seguroObl;
	}
	public void setSeguroObl(Double seguroObl) {
		this.seguroObl = seguroObl;
	}
	public Double getSeguroInteresObl() {
		return seguroInteresObl;
	}
	public void setSeguroInteresObl(Double seguroInteresObl) {
		this.seguroInteresObl = seguroInteresObl;
	}
	public double getCuotasObl() {
		return cuotasObl;
	}
	public void setCuotasObl(double cuotasObl) {
		this.cuotasObl = cuotasObl;
	}
	public Double getComisionFlujoVcf() {
		return comisionFlujoVcf;
	}
	public void setComisionFlujoVcf(Double comisionFlujoVcf) {
		this.comisionFlujoVcf = comisionFlujoVcf;
	}
	public Double getComisionInteresVcf() {
		return comisionInteresVcf;
	}
	public void setComisionInteresVcf(Double comisionInteresVcf) {
		this.comisionInteresVcf = comisionInteresVcf;
	}
	public Double getSeguroVcf() {
		return seguroVcf;
	}
	public void setSeguroVcf(Double seguroVcf) {
		this.seguroVcf = seguroVcf;
	}
	public Double getSeguroInteresVcf() {
		return seguroInteresVcf;
	}
	public void setSeguroInteresVcf(Double seguroInteresVcf) {
		this.seguroInteresVcf = seguroInteresVcf;
	}
	public double getCuotasVcf() {
		return cuotasVcf;
	}
	public void setCuotasVcf(double cuotasVcf) {
		this.cuotasVcf = cuotasVcf;
	}
	public double getCuotasVsf() {
		return cuotasVsf;
	}
	public void setCuotasVsf(double cuotasVsf) {
		this.cuotasVsf = cuotasVsf;
	}
	public Double getValorCuotaObl() {
		return valorCuotaObl;
	}
	public void setValorCuotaObl(Double valorCuotaObl) {
		this.valorCuotaObl = valorCuotaObl;
	}
	public Double getValorCuotaVcf() {
		return valorCuotaVcf;
	}
	public void setValorCuotaVcf(Double valorCuotaVcf) {
		this.valorCuotaVcf = valorCuotaVcf;
	}
	public Double getValorCuotaVsf() {
		return valorCuotaVsf;
	}
	public void setValorCuotaVsf(Double valorCuotaVsf) {
		this.valorCuotaVsf = valorCuotaVsf;
	}
	public BigDecimal getComiSaldoAbonoOBL() {
		return comiSaldoAbonoOBL;
	}
	public void setComiSaldoAbonoOBL(BigDecimal comiSaldoAbonoOBL) {
		this.comiSaldoAbonoOBL = comiSaldoAbonoOBL;
	}
	public BigDecimal getComiMixRiaAbonoOBL() {
		return comiMixRiaAbonoOBL;
	}
	public void setComiMixRiaAbonoOBL(BigDecimal comiMixRiaAbonoOBL) {
		this.comiMixRiaAbonoOBL = comiMixRiaAbonoOBL;
	}
	public BigDecimal getComiFluRiaAbonoOBL() {
		return comiFluRiaAbonoOBL;
	}
	public void setComiFluRiaAbonoOBL(BigDecimal comiFluRiaAbonoOBL) {
		this.comiFluRiaAbonoOBL = comiFluRiaAbonoOBL;
	}
	public BigDecimal getComiMixRiaCargoOBL() {
		return comiMixRiaCargoOBL;
	}
	public void setComiMixRiaCargoOBL(BigDecimal comiMixRiaCargoOBL) {
		this.comiMixRiaCargoOBL = comiMixRiaCargoOBL;
	}
	public BigDecimal getComiFluRiaCargoOBL() {
		return comiFluRiaCargoOBL;
	}
	public void setComiFluRiaCargoOBL(BigDecimal comiFluRiaCargoOBL) {
		this.comiFluRiaCargoOBL = comiFluRiaCargoOBL;
	}
	public BigDecimal getComiSaldoAbonoVCF() {
		return comiSaldoAbonoVCF;
	}
	public void setComiSaldoAbonoVCF(BigDecimal comiSaldoAbonoVCF) {
		this.comiSaldoAbonoVCF = comiSaldoAbonoVCF;
	}
	public BigDecimal getSeguNominAbonoOBL() {
		return seguNominAbonoOBL;
	}
	public void setSeguNominAbonoOBL(BigDecimal seguNominAbonoOBL) {
		this.seguNominAbonoOBL = seguNominAbonoOBL;
	}
	public BigDecimal getSeguIntereAbonoOBL() {
		return seguIntereAbonoOBL;
	}
	public void setSeguIntereAbonoOBL(BigDecimal seguIntereAbonoOBL) {
		this.seguIntereAbonoOBL = seguIntereAbonoOBL;
	}
	public BigDecimal getSeguNominCargoOBL() {
		return seguNominCargoOBL;
	}
	public void setSeguNominCargoOBL(BigDecimal seguNominCargoOBL) {
		this.seguNominCargoOBL = seguNominCargoOBL;
	}
	public BigDecimal getSeguIntereCargoOBL() {
		return seguIntereCargoOBL;
	}
	public void setSeguIntereCargoOBL(BigDecimal seguIntereCargoOBL) {
		this.seguIntereCargoOBL = seguIntereCargoOBL;
	}
	public BigDecimal getInteMixRiaAbonoOBL() {
		return inteMixRiaAbonoOBL;
	}
	public void setInteMixRiaAbonoOBL(BigDecimal inteMixRiaAbonoOBL) {
		this.inteMixRiaAbonoOBL = inteMixRiaAbonoOBL;
	}
	public BigDecimal getInteFluRiaAbonoOBL() {
		return inteFluRiaAbonoOBL;
	}
	public void setInteFluRiaAbonoOBL(BigDecimal inteFluRiaAbonoOBL) {
		this.inteFluRiaAbonoOBL = inteFluRiaAbonoOBL;
	}
	public BigDecimal getInteMixRiaCargoOBL() {
		return inteMixRiaCargoOBL;
	}
	public void setInteMixRiaCargoOBL(BigDecimal inteMixRiaCargoOBL) {
		this.inteMixRiaCargoOBL = inteMixRiaCargoOBL;
	}
	public BigDecimal getInteFluRiaCargoOBL() {
		return inteFluRiaCargoOBL;
	}
	public void setInteFluRiaCargoOBL(BigDecimal inteFluRiaCargoOBL) {
		this.inteFluRiaCargoOBL = inteFluRiaCargoOBL;
	}
	public BigDecimal getComiSaldoAbonoVSF() {
		return comiSaldoAbonoVSF;
	}
	public void setComiSaldoAbonoVSF(BigDecimal comiSaldoAbonoVSF) {
		this.comiSaldoAbonoVSF = comiSaldoAbonoVSF;
	}

	
}
