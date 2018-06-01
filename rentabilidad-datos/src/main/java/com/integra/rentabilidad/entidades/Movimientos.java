package com.integra.rentabilidad.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movimientos implements Serializable {
	private static final long serialVersionUID = 1L;

	public Movimientos() {
		super();
	}
	
	@Id
	@Column(name = "ORDEN")
	private String orden;
	@Column(name = "MOVNUM")
	private String cuspp;
	@Column(name = "MOVFEC")
	private String fechaMovimiento;
	@Column(name = "MOVSEC")
	private Double secuenciaAfiliado;
	@Column(name = "MOVVAL")
	private Double valorMovimiento;
	@Column(name = "MOVCUO")
	private double cuotasMovimiento;
	@Column(name = "MOVSIG")
	private String signo;
	@Column(name = "MOVSAL")
	private Double saldoCuentaCuotas;
	@Column(name = "MOVSE2")
	private Double secuencia;
	@Column(name = "MOVCO1")
	private String codigoExtracto;
	@Column(name = "MOVPER")
	private String periodoCotizacion;
	@Column(name = "MOVFE5")
	private String fechaPago;
	@Column(name = "MOVFE6")
	private String fechaCompraCuotas;
	@Column(name = "MOVTIP")
	private String tipoTransaccion;
	@Column(name = "MOVTI1")
	private String tipoConcepto;
	@Column(name = "MOVCOD")
	private Double codigoEmpleador;
	@Column(name = "MOVMOT")
	private String MotivoCargoAbono;
	@Column(name = "MOVIN1")
	private String indicadorPagoSoloInteres;
	@Column(name = "MOVTI7")
	private String tipoCuenta;
	@Column(name = "MOVTI8")
	private String tipoSubcuenta;
	@Column(name = "MOVTI9")
	private String tipoFondo;
	@Column(name = "MOVNRO")
	private Double numeroAcreditacion;
	@Column(name = "ETANR2")
	private String grupo;
	@Column(name = "EMPNU2")
	private String ruc;
	@Column(name = "EMPRAZ")
	private String razonSocial;
	@Column(name = "ETAFL1")
	private String flagEECC;
	@Column(name = "CODDES")
	private String descripcion;
	@Column(name = "IFDVA4")
	private Double valorCuota;
	@Column(name = "CUENTA_CALCULO")
	private String cuentaCalculo;
	
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
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public Double getSecuenciaAfiliado() {
		return secuenciaAfiliado;
	}
	public void setSecuenciaAfiliado(Double secuenciaAfiliado) {
		this.secuenciaAfiliado = secuenciaAfiliado;
	}
	public Double getValorMovimiento() {
		return valorMovimiento;
	}
	public void setValorMovimiento(Double valorMovimiento) {
		this.valorMovimiento = valorMovimiento;
	}
	public double getCuotasMovimiento() {
		return cuotasMovimiento;
	}
	public void setCuotasMovimiento(double cuotasMovimiento) {
		this.cuotasMovimiento = cuotasMovimiento;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public Double getSaldoCuentaCuotas() {
		return saldoCuentaCuotas;
	}
	public void setSaldoCuentaCuotas(Double saldoCuentaCuotas) {
		this.saldoCuentaCuotas = saldoCuentaCuotas;
	}
	public Double getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(Double secuencia) {
		this.secuencia = secuencia;
	}
	public String getCodigoExtracto() {
		return codigoExtracto;
	}
	public void setCodigoExtracto(String codigoExtracto) {
		this.codigoExtracto = codigoExtracto;
	}
	public String getPeriodoCotizacion() {
		return periodoCotizacion;
	}
	public void setPeriodoCotizacion(String periodoCotizacion) {
		this.periodoCotizacion = periodoCotizacion;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getFechaCompraCuotas() {
		return fechaCompraCuotas;
	}
	public void setFechaCompraCuotas(String fechaCompraCuotas) {
		this.fechaCompraCuotas = fechaCompraCuotas;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getTipoConcepto() {
		return tipoConcepto;
	}
	public void setTipoConcepto(String tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}
	public Double getCodigoEmpleador() {
		return codigoEmpleador;
	}
	public void setCodigoEmpleador(Double codigoEmpleador) {
		this.codigoEmpleador = codigoEmpleador;
	}
	public String getMotivoCargoAbono() {
		return MotivoCargoAbono;
	}
	public void setMotivoCargoAbono(String motivoCargoAbono) {
		MotivoCargoAbono = motivoCargoAbono;
	}
	public String getIndicadorPagoSoloInteres() {
		return indicadorPagoSoloInteres;
	}
	public void setIndicadorPagoSoloInteres(String indicadorPagoSoloInteres) {
		this.indicadorPagoSoloInteres = indicadorPagoSoloInteres;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getTipoSubcuenta() {
		return tipoSubcuenta;
	}
	public void setTipoSubcuenta(String tipoSubcuenta) {
		this.tipoSubcuenta = tipoSubcuenta;
	}
	public String getTipoFondo() {
		return tipoFondo;
	}
	public void setTipoFondo(String tipoFondo) {
		this.tipoFondo = tipoFondo;
	}
	public Double getNumeroAcreditacion() {
		return numeroAcreditacion;
	}
	public void setNumeroAcreditacion(Double numeroAcreditacion) {
		this.numeroAcreditacion = numeroAcreditacion;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getRuc() {
		return ruc == null ? "" : ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial == null ? "" : razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getFlagEECC() {
		return flagEECC;
	}
	public void setFlagEECC(String flagEECC) {
		this.flagEECC = flagEECC;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(Double valorCuota) {
		this.valorCuota = valorCuota;
	}
	public String getCuentaCalculo() {
		return cuentaCalculo;
	}
	public void setCuentaCalculo(String cuentaCalculo) {
		this.cuentaCalculo = cuentaCalculo;
	}

}
