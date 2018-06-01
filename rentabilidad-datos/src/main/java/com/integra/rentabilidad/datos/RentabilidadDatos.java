package com.integra.rentabilidad.datos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.integra.rentabilidad.base.DatosBase;
import com.integra.rentabilidad.entidades.Comision;
import com.integra.rentabilidad.entidades.ComisionFlujo;
import com.integra.rentabilidad.entidades.ComisionFlujoJSON;
import com.integra.rentabilidad.entidades.ComisionMovimiento;
import com.integra.rentabilidad.entidades.ComisionSaldoJSON;
import com.integra.rentabilidad.entidades.Cuear5;
import com.integra.rentabilidad.entidades.Etrarc;
import com.integra.rentabilidad.entidades.Ifdar7;
import com.integra.rentabilidad.entidades.ListaCuspp;
import com.integra.rentabilidad.entidades.Movimientos;
import com.integra.rentabilidad.entidades.MovimientosJSON;
import com.integra.rentabilidad.entidades.Producto;
import com.integra.rentabilidad.entidades.Rentabilidad;
import com.integra.rentabilidad.entidades.RentabilidadEECC;
import com.integra.rentabilidad.global.Constantes;
import com.integra.rentabilidad.global.Procedimientos;

@Stateless
public class RentabilidadDatos extends DatosBase {
	
	private final static Logger LOGGER = LogManager.getLogger(RentabilidadDatos.class);

	public String obtenerRentabilidad(String cuspp, String fechaInicio, String fechaFin, String flag) {
		LOGGER.traceEntry();
		List<Movimientos> lstMovimientos = new ArrayList<>();
		List<Rentabilidad> lstRentabilidad = new ArrayList<>();
		List<ListaCuspp> lstCuspp = new ArrayList<>();
		List<Cuear5> lstCuear5 = new ArrayList<>();
		List<Etrarc> lstEtrarc = new ArrayList<>();
		List<Ifdar7> lstValoresCuota = new ArrayList<>();
		List<Ifdar7> lstValoresCuotaInicial = new ArrayList<>();
		List<Ifdar7> lstValoresCuotaFinal = new ArrayList<>();
		List<ComisionFlujo> lstComisionFlujo = new ArrayList<>();
		RentabilidadEECC rentabilidadEECC = null;

		try {
			lstRentabilidad = ejecutarProcedimientoAlmacenadoRentabilidad(cuspp, fechaInicio, fechaFin, flag);
			lstCuear5 = ejecutarProcedimientoAlmacenadoCuear5(cuspp);
			lstMovimientos = ejecutarProcedimientoAlmacenadoMovimientos(cuspp, fechaInicio, fechaFin, flag);
			lstCuspp = ejecutarProcedimientoAlmacenadoListaCuspp(cuspp);
			lstEtrarc = ejecutarProcedimientoAlmacenadoEtaarc(cuspp);
			lstComisionFlujo = ejecutarProcedimientoAlmacenadoComisiones(cuspp, fechaInicio, fechaFin, flag);
			lstValoresCuota = ejecutarProcedimientoAlmacenadoValorCuota(fechaInicio, fechaFin, flag);
			
			// OBL
			double abono_1 = 0;
			double abono_2 = 0;
			double abono_3 = 0;
			double abono_4 = 0;
			double abono_5 = 0;
			double abono_6 = 0; // X
			double cargo_1 = 0;
			double cargo_2 = 0;
			double cargo_3 = 0;
			double cargo_4 = 0;
			double cargo_5 = 0;
			double cargo_6 = 0; // X
			// VCF
			double abono_7 = 0;
			double abono_8 = 0;
			double abono_9 = 0;
			double abono_10 = 0;
			double abono_11 = 0;
			double abono_12 = 0; // X
			double cargo_7 = 0;
			double cargo_8 = 0;
			double cargo_9 = 0;
			double cargo_10 = 0;
			double cargo_11 = 0;
			double cargo_12 = 0; // X
			// VSF
			double abono_13 = 0;
			double abono_14 = 0;
			double abono_15 = 0;
			double abono_16 = 0;
			double abono_17 = 0;
			double abono_18 = 0; // X
			double cargo_13 = 0;
			double cargo_14 = 0;
			double cargo_15 = 0;
			double cargo_16 = 0;
			double cargo_17 = 0;
			double cargo_18 = 0; // X
			
			double cuotasSaldoMovarcObl = 0;
			double cuotasSaldoMovarcVcf = 0;
			double cuotasSaldoMovarcVsf = 0;
						
			// OBL
			double abonoXcuota_1 = 0;
			double abonoXcuota_2 = 0;
			double abonoXcuota_3 = 0;
			double abonoXcuota_4 = 0;
			double abonoXcuota_5 = 0;
			double abonoXcuota_6 = 0; // X
			double cargoXcuota_1 = 0;
			double cargoXcuota_2 = 0;
			double cargoXcuota_3 = 0;
			double cargoXcuota_4 = 0;
			double cargoXcuota_5 = 0;
			double cargoXcuota_6 = 0; // X
			// VCF
			double abonoXcuota_7 = 0;
			double abonoXcuota_8 = 0;
			double abonoXcuota_9 = 0;
			double abonoXcuota_10 = 0;
			double abonoXcuota_11 = 0;
			double abonoXcuota_12 = 0; // X
			double cargoXcuota_7 = 0;
			double cargoXcuota_8 = 0;
			double cargoXcuota_9 = 0;
			double cargoXcuota_10 = 0;
			double cargoXcuota_11 = 0;
			double cargoXcuota_12 = 0; // X
			// VSF
			double abonoXcuota_13 = 0;
			double abonoXcuota_14 = 0;
			double abonoXcuota_15 = 0;
			double abonoXcuota_16 = 0;
			double abonoXcuota_17 = 0;
			double abonoXcuota_18 = 0; // X
			double cargoXcuota_13 = 0;
			double cargoXcuota_14 = 0;
			double cargoXcuota_15 = 0;
			double cargoXcuota_16 = 0;
			double cargoXcuota_17 = 0;
			double cargoXcuota_18 = 0; // X
			
			double cuotasObl = 0.0;
			double cuotasVcf = 0.0;
			double cuotasVsf = 0.0;
			
			// OTXXXXX - Comisiones INI
			double comiSaldoAbonoOBL = 0.0;
			double comiMixRiaAbonoOBL = 0.0;
			double comiFluRiaAbonoOBL = 0.0;
			//BigDecimal comiSaldoCargoOBL = new BigDecimal("0.00");
			double comiMixRiaCargoOBL = 0.0;
			double comiFluRiaCargoOBL = 0.0;
			double comiSaldoAbonoVCF = 0.0;
			double comiSaldoAbonoVSF = 0.0;
			//BigDecimal comiMixRiaAbonoVCF = new BigDecimal("0.00");
			//BigDecimal comiFluRiaAbonoVCF = new BigDecimal("0.00");
			//BigDecimal comiSaldoCargoVCF = new BigDecimal("0.00");
			//BigDecimal comiMixRiaCargoVCF = new BigDecimal("0.00");
			//BigDecimal comiFluRiaCargoVCF = new BigDecimal("0.00");
			double seguNominAbonoOBL = 0.0;
			double seguIntereAbonoOBL = 0.0;
			double seguNominCargoOBL = 0.0;
			double seguIntereCargoOBL = 0.0;
			//BigDecimal seguNominAbonoVCF = new BigDecimal("0.00");
			//BigDecimal seguIntereAbonoVCF = new BigDecimal("0.00");
			//BigDecimal seguNominCargoVCF = new BigDecimal("0.00");
			//BigDecimal seguIntereCargoVCF = new BigDecimal("0.00");
			//BigDecimal inteSaldoAbonoOBL = new BigDecimal("0.00");
			double inteMixRiaAbonoOBL = 0.0;
			double inteFluRiaAbonoOBL = 0.0;
			//BigDecimal inteSaldoCargoOBL = new BigDecimal("0.00");
			double inteMixRiaCargoOBL = 0.0;
			double inteFluRiaCargoOBL = 0.0;
			//BigDecimal inteSaldoAbonoVCF = new BigDecimal("0.00");
			//BigDecimal inteMixRiaAbonoVCF = new BigDecimal("0.00");
			//BigDecimal inteFluRiaAbonoVCF = new BigDecimal("0.00");
			//BigDecimal inteSaldoCargoVCF = new BigDecimal("0.00");
			//BigDecimal inteMixRiaCargoVCF = new BigDecimal("0.00");
			//BigDecimal inteFluRiaCargoVCF = new BigDecimal("0.00");
			// OTXXXXX - Comisiones FIN
			
			boolean tieneObl = false;
			boolean tieneVcf = false;
			boolean tieneVsf = false;
			
			// Variables para el objeto JSON
			Producto productoObl = new Producto();
			Producto productoVcf = new Producto();
			Producto productoVsf = new Producto();
			Cuear5 cuear5 = null;
			Etrarc etrarc = null;
			List<MovimientosJSON> lstMovimientosOblJSON = new ArrayList<>();
			List<ComisionFlujoJSON> lstComisionFlujoOblJSON = new ArrayList<>();
			List<ComisionSaldoJSON> lstComisionSaldoOblJSON = new ArrayList<>();
			List<MovimientosJSON> lstMovimientosVcfJSON = new ArrayList<>();
			List<ComisionFlujoJSON> lstComisionFlujoVcfJSON = new ArrayList<>();
			List<ComisionSaldoJSON> lstComisionSaldoVcfJSON = new ArrayList<>();
			List<MovimientosJSON> lstMovimientosVsfJSON = new ArrayList<>();
			List<ComisionFlujoJSON> lstComisionFlujoVsfJSON = new ArrayList<>();
			List<ComisionSaldoJSON> lstComisionSaldoVsfJSON = new ArrayList<>();
			
			String flagMovimientoObl = Constantes.SIN_ERROR;
			String flagMovimientoVcf = Constantes.SIN_ERROR;
			String flagMovimientoVsf = Constantes.SIN_ERROR;
			List<String> lstFlagMovimientoObl = new ArrayList<>();
			List<String> lstFlagMovimientoVcf = new ArrayList<>();
			List<String> lstFlagMovimientoVsf = new ArrayList<>();
			List<String> lstFondoMovimientoObl = new ArrayList<>();
			List<String> lstFondoMovimientoVcf = new ArrayList<>();
			List<String> lstFondoMovimientoVsf = new ArrayList<>();
			
			//*****************************************************************************************************************************************************
			//* OBTENER MOVIMIENTOS
			//*****************************************************************************************************************************************************
			if (lstMovimientos != null ) {
				for (int i = 0; i < lstMovimientos.size(); i++) {
					flagMovimientoObl = Constantes.SIN_ERROR;
					flagMovimientoVcf = Constantes.SIN_ERROR;
					flagMovimientoVsf = Constantes.SIN_ERROR;
					Movimientos movimiento = (Movimientos) lstMovimientos.get(i);

					if (movimiento.getTipoCuenta().equals(Constantes.CUENTA_OBL)) {
						MovimientosJSON movimientoOblJSON = new MovimientosJSON();
						tieneObl = true;
						
						if (movimiento.getGrupo().equals(Constantes.GRUPO_CARGO_2)) {
							ComisionSaldoJSON comisionSaldo = new ComisionSaldoJSON();
							comisionSaldo.setPeriodoComision(movimiento.getFechaMovimiento().substring(0, 6));
							if (movimiento.getSigno().trim().equals("") || movimiento.getSigno().trim().equals("+")) {
								comisionSaldo.setMontoComision(movimiento.getValorMovimiento());
							} else {
								comisionSaldo.setMontoComision(Math.abs(movimiento.getValorMovimiento())*(-1));
							}
							
							lstComisionSaldoOblJSON.add(comisionSaldo);
						}
						
						if (movimiento.getCuentaCalculo().equals("1")) {
							switch (movimiento.getGrupo()) {
								case Constantes.GRUPO_ABONO_1:
									abono_1 = abono_1 + movimiento.getValorMovimiento(); 
									abonoXcuota_1 = abonoXcuota_1 + (movimiento.getCuotasMovimiento() * movimiento.getValorCuota());
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_ABONO_2:
									abono_2 = abono_2 + movimiento.getValorMovimiento();
									abonoXcuota_2 = abonoXcuota_2 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_ABONO_3:
									abono_3 = abono_3 + movimiento.getValorMovimiento();
									abonoXcuota_3 = abonoXcuota_3 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_ABONO_4:
									abono_4 = abono_4 + movimiento.getValorMovimiento();
									abonoXcuota_4 = abonoXcuota_4 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_ABONO_5:
									abono_5 = abono_5 + movimiento.getValorMovimiento();
									abonoXcuota_5 = abonoXcuota_5 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_CARGO_1:
									cargo_1 = cargo_1 + movimiento.getValorMovimiento();
									cargoXcuota_1 = cargoXcuota_1 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_CARGO_2:
									cargo_2 = cargo_2 + movimiento.getValorMovimiento();
									cargoXcuota_2 = cargoXcuota_2 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									comiSaldoAbonoOBL = comiSaldoAbonoOBL + Math.abs(movimiento.getValorMovimiento());
									break;
								case Constantes.GRUPO_CARGO_3:
									cargo_3 = cargo_3 + movimiento.getValorMovimiento();
									cargoXcuota_3 = cargoXcuota_3 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									break;
								case Constantes.GRUPO_CARGO_4:
									cargo_4 = cargo_4 + movimiento.getValorMovimiento();
									cargoXcuota_4 = cargoXcuota_4 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								case Constantes.GRUPO_CARGO_5:
									cargo_5 = cargo_5 + movimiento.getValorMovimiento();
									cargoXcuota_5 = cargoXcuota_5 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									cuotasSaldoMovarcObl = cuotasSaldoMovarcObl + movimiento.getCuotasMovimiento();
									break;
								// OTXXXXX - Comisiones INI
								/*case Constantes.GRUPO_COMI_SAL_ABO_OBL:
									comiSaldoAbonoOBL = comiSaldoAbonoOBL.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
									break;*/
								case Constantes.GRUPO_COMI_MIX_ABO_OBL:
									comiMixRiaAbonoOBL = comiMixRiaAbonoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_COMI_FLU_ABO_OBL:
									comiFluRiaAbonoOBL = comiFluRiaAbonoOBL + movimiento.getValorMovimiento();
									break;
								/*case Constantes.GRUPO_COMI_SAL_CAR_OBL:
									comiSaldoCargoOBL = comiSaldoCargoOBL.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
									break;*/
								case Constantes.GRUPO_COMI_MIX_CAR_OBL:
									comiMixRiaCargoOBL = comiMixRiaCargoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_COMI_FLU_CAR_OBL:
									comiFluRiaCargoOBL = comiFluRiaCargoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_SEG_NOMI_ABO_OBL:
									seguNominAbonoOBL = seguNominAbonoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_SEG_INTE_ABO_OBL:
									seguIntereAbonoOBL = seguIntereAbonoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_SEG_NOMI_CAR_OBL:
									seguNominCargoOBL = seguNominCargoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_SEG_INTE_CAR_OBL:
									seguIntereCargoOBL = seguIntereCargoOBL + movimiento.getValorMovimiento();
									break;
								/*case Constantes.GRUPO_INT_SAL_ABO_OBL:
									inteSaldoAbonoOBL = inteSaldoAbonoOBL.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
									break;*/
								case Constantes.GRUPO_INT_MIX_ABO_OBL:
									inteMixRiaAbonoOBL = inteMixRiaAbonoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_INT_FLU_ABO_OBL:
									inteFluRiaAbonoOBL = inteFluRiaAbonoOBL + movimiento.getValorMovimiento();
									break;
								/*case Constantes.GRUPO_INT_SAL_CAR_OBL:
									inteSaldoCargoOBL = inteSaldoCargoOBL.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
									break;*/
								case Constantes.GRUPO_INT_MIX_CAR_OBL:
									inteMixRiaCargoOBL = inteMixRiaCargoOBL + movimiento.getValorMovimiento();
									break;
								case Constantes.GRUPO_INT_FLU_CAR_OBL:
									inteFluRiaCargoOBL = inteFluRiaCargoOBL + movimiento.getValorMovimiento();
									break;
								// OTXXXXX - Comisiones FIN
								default:
									flagMovimientoObl = Constantes.ERROR_MOV_SIN_MAPEO;
									if (movimiento.getSigno().equals("+") || movimiento.getSigno().trim().equals("")) {
										abono_6 = abono_6 + movimiento.getValorMovimiento();
										abonoXcuota_6 = abonoXcuota_6 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									} else {
										cargo_6 = cargo_6 + movimiento.getValorMovimiento();
										cargoXcuota_6 = cargoXcuota_6 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
									}
							}
						}
						
						String ruc = movimiento.getRuc().trim().toUpperCase();
						String razonSocial = movimiento.getRazonSocial().trim().toUpperCase();
						
						if (ruc.equals("NO APLICABLE")) {
							razonSocial = "";
						}
						
						movimientoOblJSON.setFechaMovimiento(movimiento.getFechaMovimiento());
						movimientoOblJSON.setValor(movimiento.getValorMovimiento());
						movimientoOblJSON.setCuotas(movimiento.getCuotasMovimiento());
						movimientoOblJSON.setSigno(movimiento.getSigno());
						movimientoOblJSON.setCodigoExtracto(movimiento.getCodigoExtracto());
						movimientoOblJSON.setPeriodo(movimiento.getPeriodoCotizacion());
						movimientoOblJSON.setFechaPago(movimiento.getFechaPago());
						movimientoOblJSON.setRuc(ruc);
						movimientoOblJSON.setRazonSocial(razonSocial);
						movimientoOblJSON.setMotivo(movimiento.getMotivoCargoAbono());
						movimientoOblJSON.setFlagEECC(movimiento.getFlagEECC());
						movimientoOblJSON.setDescripcion(movimiento.getDescripcion());

						if (movimiento.getCuentaCalculo().equals("1")) {
							if (movimiento.getSigno().trim().equals("") || movimiento.getSigno().trim().equals("+")) {
								cuotasObl = cuotasObl + movimiento.getCuotasMovimiento();
							} else {
								cuotasObl = cuotasObl + movimiento.getCuotasMovimiento()*(-1);
							}
							
							lstFlagMovimientoObl.add(flagMovimientoObl);
							if (!movimiento.getTipoFondo().trim().equals("")) {
								lstFondoMovimientoObl.add(movimiento.getTipoFondo());
							}
						}
						
						lstMovimientosOblJSON.add(movimientoOblJSON);
					} else if (movimiento.getTipoCuenta().equals(Constantes.CUENTA_VOL)) {
						if (movimiento.getTipoSubcuenta().equals(Constantes.SUBCUENTA_VCF)) {
							MovimientosJSON movimientoVcfJSON = new MovimientosJSON();
							tieneVcf = true;
							
							if (movimiento.getGrupo().equals(Constantes.GRUPO_CARGO_8)) {
								ComisionSaldoJSON comisionSaldo = new ComisionSaldoJSON();
								comisionSaldo.setPeriodoComision(movimiento.getFechaMovimiento().substring(0, 6));
								comisionSaldo.setMontoComision(movimiento.getValorMovimiento());
								
								if (movimiento.getSigno().trim().equals("") || movimiento.getSigno().trim().equals("+")) {
									comisionSaldo.setMontoComision(movimiento.getValorMovimiento());
								} else {
									comisionSaldo.setMontoComision(Math.abs(movimiento.getValorMovimiento())*(-1));
								}
								
								lstComisionSaldoVcfJSON.add(comisionSaldo);
							}
							
							if (movimiento.getCuentaCalculo().equals("1")) {
								switch (movimiento.getGrupo()) {
									case Constantes.GRUPO_ABONO_7:
										abono_7 = abono_7 + movimiento.getValorMovimiento();
										abonoXcuota_7 = abonoXcuota_7 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_8:
										abono_8 = abono_8 + movimiento.getValorMovimiento();
										abonoXcuota_8 = abonoXcuota_8 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_9:
										abono_9 = abono_9 + movimiento.getValorMovimiento();
										abonoXcuota_9 = abonoXcuota_9 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_10:
										abono_10 = abono_10 + movimiento.getValorMovimiento();
										abonoXcuota_10 = abonoXcuota_10 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_11:
										abono_11 = abono_11 + movimiento.getValorMovimiento();
										abonoXcuota_11 = abonoXcuota_11 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_7:
										cargo_7 = cargo_7 + movimiento.getValorMovimiento();
										cargoXcuota_7 = cargoXcuota_7 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_8:
										cargo_8 = cargo_8 + movimiento.getValorMovimiento();
										cargoXcuota_8 = cargoXcuota_8 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										comiSaldoAbonoVCF = comiSaldoAbonoVCF + Math.abs(movimiento.getValorMovimiento());
										break;
									case Constantes.GRUPO_CARGO_9:
										cargo_9 = cargo_9 + movimiento.getValorMovimiento();
										cargoXcuota_9 = cargoXcuota_9 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_10:
										cargo_10 = cargo_10 + movimiento.getValorMovimiento();
										cargoXcuota_10 = cargoXcuota_10 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_11:
										cargo_11 = cargo_11 + movimiento.getValorMovimiento();
										cargoXcuota_11 = cargoXcuota_11 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVcf = cuotasSaldoMovarcVcf + movimiento.getCuotasMovimiento();
										break;
									// OTXXXXX - Comisiones INI
									/*case Constantes.GRUPO_COMI_SAL_ABO_VCF:
										comiSaldoAbonoVCF = comiSaldoAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_COMI_MIX_ABO_VCF:
										comiMixRiaAbonoVCF = comiMixRiaAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_COMI_FLU_ABO_VCF:
										comiFluRiaAbonoVCF = comiFluRiaAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_COMI_SAL_CAR_VCF:
										comiSaldoCargoVCF = comiSaldoCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_COMI_MIX_CAR_VCF:
										comiMixRiaCargoVCF = comiMixRiaCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_COMI_FLU_CAR_VCF:
										comiFluRiaCargoVCF = comiFluRiaCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_SEG_NOMI_ABO_VCF:
										seguNominAbonoVCF = seguNominAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_SEG_INTE_ABO_VCF:
										seguIntereAbonoVCF = seguIntereAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_SEG_NOMI_CAR_VCF:
										seguNominCargoVCF = seguNominCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_SEG_INTE_CAR_VCF:
										seguIntereCargoVCF = seguIntereCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;*/
										
									/*case Constantes.GRUPO_INT_SAL_ABO_VCF:
										inteSaldoAbonoVCF = inteSaldoAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;*/
									/*case Constantes.GRUPO_INT_MIX_ABO_VCF:
										inteMixRiaAbonoVCF = inteMixRiaAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_INT_FLU_ABO_VCF:
										inteFluRiaAbonoVCF = inteFluRiaAbonoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;*/
									/*case Constantes.GRUPO_INT_SAL_CAR_VCF:
										inteSaldoCargoVCF = inteSaldoCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;*/
									/*case Constantes.GRUPO_INT_MIX_CAR_VCF:
										inteMixRiaCargoVCF = inteMixRiaCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;
									case Constantes.GRUPO_INT_FLU_CAR_VCF:
										inteFluRiaCargoVCF = inteFluRiaCargoVCF.add(new BigDecimal(movimiento.getValorMovimiento().toString()));
										break;*/
									// OTXXXXX - Comisiones FIN
									default:
										flagMovimientoVcf = Constantes.ERROR_MOV_SIN_MAPEO;
										if (movimiento.getSigno().equals("+") || movimiento.getSigno().trim().equals("")) {
											abono_12 = abono_12 + movimiento.getValorMovimiento();
											abonoXcuota_12 = abonoXcuota_12 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										} else {
											cargo_12 = cargo_12 + movimiento.getValorMovimiento();
											cargoXcuota_12 = cargoXcuota_12 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										}
								}
							}
							
							String ruc = movimiento.getRuc().trim().toUpperCase();
							String razonSocial = movimiento.getRazonSocial().trim().toUpperCase();
							
							if (ruc.equals("NO APLICABLE")) {
								razonSocial = "";
							}
							
							movimientoVcfJSON.setFechaMovimiento(movimiento.getFechaMovimiento());
							movimientoVcfJSON.setValor(movimiento.getValorMovimiento());
							movimientoVcfJSON.setCuotas(movimiento.getCuotasMovimiento());
							movimientoVcfJSON.setSigno(movimiento.getSigno());
							movimientoVcfJSON.setCodigoExtracto(movimiento.getCodigoExtracto());
							movimientoVcfJSON.setPeriodo(movimiento.getPeriodoCotizacion());
							movimientoVcfJSON.setFechaPago(movimiento.getFechaPago());
							movimientoVcfJSON.setRuc(ruc);
							movimientoVcfJSON.setRazonSocial(razonSocial);
							movimientoVcfJSON.setMotivo(movimiento.getMotivoCargoAbono());
							movimientoVcfJSON.setFlagEECC(movimiento.getFlagEECC());
							movimientoVcfJSON.setDescripcion(movimiento.getDescripcion());
							
							if (movimiento.getCuentaCalculo().equals("1")) {
								if (movimiento.getSigno().trim().equals("") || movimiento.getSigno().trim().equals("+")) {
									cuotasVcf = cuotasVcf + movimiento.getCuotasMovimiento();
								} else {
									cuotasVcf = cuotasVcf + movimiento.getCuotasMovimiento()*(-1);
								}
								
								lstFlagMovimientoVcf.add(flagMovimientoVcf);
								if (!movimiento.getTipoFondo().trim().equals("")) {
									lstFondoMovimientoVcf.add(movimiento.getTipoFondo());
								}
							}
							
							lstMovimientosVcfJSON.add(movimientoVcfJSON);
						} else if (movimiento.getTipoSubcuenta().equals(Constantes.SUBCUENTA_VSF)) {
							MovimientosJSON movimientoVsfJSON = new MovimientosJSON();
							tieneVsf = true;
							
							if (movimiento.getGrupo().equals(Constantes.GRUPO_CARGO_14)) {
								ComisionSaldoJSON comisionSaldo = new ComisionSaldoJSON();
								comisionSaldo.setPeriodoComision(movimiento.getFechaMovimiento().substring(0, 6));

								if (movimiento.getSigno().trim().equals("") || movimiento.getSigno().trim().equals("+")) {
									comisionSaldo.setMontoComision(movimiento.getValorMovimiento());
								} else {
									comisionSaldo.setMontoComision(Math.abs(movimiento.getValorMovimiento())*(-1));
								}
								
								lstComisionSaldoVsfJSON.add(comisionSaldo);
							}

							if (movimiento.getCuentaCalculo().equals("1")) {
								switch (movimiento.getGrupo()) {
									case Constantes.GRUPO_ABONO_13:
										abono_13 = abono_13 + movimiento.getValorMovimiento();
										abonoXcuota_13 = abonoXcuota_13 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_14:
										abono_14 = abono_14 + movimiento.getValorMovimiento();
										abonoXcuota_14 = abonoXcuota_14 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_15:
										abono_15 = abono_15 + movimiento.getValorMovimiento();
										abonoXcuota_15 = abonoXcuota_15 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_16:
										abono_16 = abono_16 + movimiento.getValorMovimiento();
										abonoXcuota_16 = abonoXcuota_16 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_ABONO_17:
										abono_17 = abono_17 + movimiento.getValorMovimiento();
										abonoXcuota_17 = abonoXcuota_17 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_13:
										cargo_13 = cargo_13 + movimiento.getValorMovimiento();
										cargoXcuota_13 = cargoXcuota_13 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_14:
										cargo_14 = cargo_14 + movimiento.getValorMovimiento();
										cargoXcuota_14 = cargoXcuota_14 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										comiSaldoAbonoVSF = comiSaldoAbonoVSF + Math.abs(movimiento.getValorMovimiento());
										break;
									case Constantes.GRUPO_CARGO_15:
										cargo_15 = cargo_15 + movimiento.getValorMovimiento();
										cargoXcuota_15 = cargoXcuota_15 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_16:
										cargo_16 = cargo_16 + movimiento.getValorMovimiento();
										cargoXcuota_16 = cargoXcuota_16 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									case Constantes.GRUPO_CARGO_17:
										cargo_17 = cargo_17 + movimiento.getValorMovimiento();
										cargoXcuota_17 = cargoXcuota_17 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										cuotasSaldoMovarcVsf = cuotasSaldoMovarcVsf + movimiento.getCuotasMovimiento();
										break;
									default:
										flagMovimientoVsf = Constantes.ERROR_MOV_SIN_MAPEO;
										if (movimiento.getSigno().equals("+") || movimiento.getSigno().trim().equals("")) {
											abono_18 = abono_18 + movimiento.getValorMovimiento();
											abonoXcuota_18 = abonoXcuota_18 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										} else {
											cargo_18 = cargo_18 + movimiento.getValorMovimiento();
											cargoXcuota_18 = cargoXcuota_18 + movimiento.getCuotasMovimiento() * movimiento.getValorCuota();
										}
								}
							}
							
							String ruc = movimiento.getRuc().trim().toUpperCase();
							String razonSocial = movimiento.getRazonSocial().trim().toUpperCase();
							
							if (ruc.equals("NO APLICABLE")) {
								razonSocial = "";
							}
							
							movimientoVsfJSON.setFechaMovimiento(movimiento.getFechaMovimiento());
							movimientoVsfJSON.setValor(movimiento.getValorMovimiento());
							movimientoVsfJSON.setCuotas(movimiento.getCuotasMovimiento());
							movimientoVsfJSON.setSigno(movimiento.getSigno());
							movimientoVsfJSON.setCodigoExtracto(movimiento.getCodigoExtracto());
							movimientoVsfJSON.setPeriodo(movimiento.getPeriodoCotizacion());
							movimientoVsfJSON.setFechaPago(movimiento.getFechaPago());
							movimientoVsfJSON.setRuc(ruc);
							movimientoVsfJSON.setRazonSocial(razonSocial);
							movimientoVsfJSON.setMotivo(movimiento.getMotivoCargoAbono());
							movimientoVsfJSON.setFlagEECC(movimiento.getFlagEECC());
							movimientoVsfJSON.setDescripcion(movimiento.getDescripcion());
							
							if (movimiento.getCuentaCalculo().equals("1")) {
								if (movimiento.getSigno().trim().equals("") || movimiento.getSigno().trim().equals("+")) {
									cuotasVsf = cuotasVsf + movimiento.getCuotasMovimiento();
								} else {
									cuotasVsf = cuotasVsf + movimiento.getCuotasMovimiento()*(-1);
								}
								
								lstFlagMovimientoVsf.add(flagMovimientoVsf);
								if (!movimiento.getTipoFondo().trim().equals("")) {
									lstFondoMovimientoVsf.add(movimiento.getTipoFondo());
								}
							}
							
							lstMovimientosVsfJSON.add(movimientoVsfJSON);
						}
					}
				}
			}
			//*****************************************************************************************************************************************************
			//*****************************************************************************************************************************************************
			
			if (lstComisionFlujo != null && lstComisionFlujo.size() > 0) {
				for (int i = 0; i < lstComisionFlujo.size(); i++) {
					ComisionFlujo comisionFlujo = lstComisionFlujo.get(i);
					ComisionFlujoJSON comision = new ComisionFlujoJSON();
					
					if (comisionFlujo.getPeriodo().equals("")) {
						comision.setPeriodoComision(comisionFlujo.getFecha().substring(0, 6));
					} else {
						comision.setPeriodoComision(comisionFlujo.getPeriodo());
					}
					
					comision.setMontoComisionADM(comisionFlujo.getComision() + comisionFlujo.getInteresComision());;
					comision.setMontoSeguro(comisionFlujo.getSeguro() + comisionFlujo.getInteresSeguro());
					
					lstComisionFlujoOblJSON.add(comision);
				}
			}

			double rentabilidadPeriodoInicialObl = 0;
			double rentabilidadPeriodoFinalObl = 0;
			double rentabilidadPeriodoTotalObl = 0;
			double rentabilidadPeriodoInicialVcf = 0;
			double rentabilidadPeriodoFinalVcf = 0;
			double rentabilidadPeriodoTotalVcf = 0;
			double rentabilidadPeriodoInicialVsf = 0;
			double rentabilidadPeriodoFinalVsf = 0;
			double rentabilidadPeriodoTotalVsf = 0;
			
			double saldoCicObl = 0;
			double saldoCicVcf = 0;
			double saldoCicVsf = 0;

			// Calculo Rentabilidad Integra
			if (lstCuear5 != null && lstCuear5.size() > 0) {
				cuear5 = (Cuear5)lstCuear5.get(0);
			} else {
				cuear5 = new Cuear5();
				cuear5.setCuspp(cuspp);
			}
			
			double acreditacionesInicialObl = 0;
			double cargosInicialObl = 0;
			double acreditacionesInicialVcf = 0;
			double cargosInicialVcf = 0;
			double acreditacionesInicialVsf = 0;
			double cargosInicialVsf = 0;
			
			double acreditacionesFinalObl = 0;
			double cargosFinalObl = 0;
			double acreditacionesFinalVcf = 0;
			double cargosFinalVcf = 0;
			double acreditacionesFinalVsf = 0;
			double cargosFinalVsf = 0;
			
			boolean tieneEtrarc = false;
			
			if (lstEtrarc != null && lstEtrarc.size() > 0) {
				etrarc = (Etrarc) lstEtrarc.get(0);
				
				tieneEtrarc = true;
			}
			
			double rentabilidadObl = 0;
			double rentabilidadVcf = 0;
			double rentabilidadVsf = 0;
			
			double acreditacionesEtarcObl = 0;
			double acreditacionesEtarcVcf = 0;
			double acreditacionesEtarcVsf = 0;
			double cargosEtarcObl = 0;
			double cargosEtarcVcf = 0;
			double cargosEtarcVsf = 0;
			
			double saldoAfectoObl = 0;
			double saldoAfectoVcf = 0;
			double saldoAfectoVsf = 0;
			double saldoInafectoObl = 0;
			double saldoInafectoVcf = 0;
			double saldoInafectoVsf = 0;
			
			if (tieneEtrarc) {
				if (etrarc.getFlagCargaRenta().equals("1")) {
					acreditacionesEtarcObl = etrarc.getAporteObl_1() + etrarc.getAporteObl_2() + etrarc.getAporteObl_3();
					acreditacionesEtarcVcf = etrarc.getAporteVcf_1() + etrarc.getAporteVcf_2();
					cargosEtarcObl = etrarc.getCargoObl_1();
					cargosEtarcVcf = etrarc.getCargoVcf_1();
				}

				rentabilidadPeriodoInicialObl = rentabilidadPeriodoInicialObl - acreditacionesEtarcObl - cargosEtarcObl;
				rentabilidadPeriodoFinalObl = rentabilidadPeriodoFinalObl - acreditacionesEtarcObl - cargosEtarcObl;
				
				rentabilidadPeriodoInicialVcf = rentabilidadPeriodoInicialVcf - acreditacionesEtarcVcf - cargosEtarcVcf;
				rentabilidadPeriodoFinalVcf = rentabilidadPeriodoFinalVcf - acreditacionesEtarcVcf - cargosEtarcVcf;
			}
			
			if (cuear5 != null) {
				saldoAfectoObl = cuear5.getSaldoAfectoObl();
				saldoAfectoVcf = cuear5.getSaldoAfectoVCF();
				saldoAfectoVsf = cuear5.getSaldoAfectoVSF();
				saldoInafectoObl = cuear5.getSaldoInafectoObl();
				saldoInafectoVcf = cuear5.getSaldoInafectoVCF();
				saldoInafectoVsf = cuear5.getSaldoInafectoVSF();
			}
			
			String tipoFondoObl = "";
			String tipoFondoVcf = "";
			String tipoFondoVsf = "";
			
			double saldoInicialObl = 0;
			double saldoInicialVcf = 0;
			double saldoInicialVsf = 0;
			double saldoFinalObl = 0;
			double saldoFinalVcf = 0;
			double saldoFinalVsf = 0;
			
			boolean tieneErrorRenaObl = false;
			boolean tieneErrorRenaVcf = false;
			boolean tieneErrorRenaVsf = false;
			
			boolean tieneTraspasoObl = false;
			boolean tieneTraspasoVcf = false;
			boolean tieneTraspasoVsf = false;
			
			boolean tieneRena04 = false;
			
			double valorCuotaInicialObl = 0;
			double valorCuotaInicialVcf = 0;
			double valorCuotaInicialVsf = 0;
			double valorCuotaFinalObl = 0;
			double valorCuotaFinalVcf = 0;
			double valorCuotaFinalVsf = 0;
			
			for (int i = 0; i < lstValoresCuota.size(); i++) {
				Ifdar7 ifdar7 = lstValoresCuota.get(i);
				
				if (ifdar7.getTexto().equals("INICIO")) {
					lstValoresCuotaInicial.add(ifdar7);
				} else {
					lstValoresCuotaFinal.add(ifdar7);
				}
			}
			
			// OTXXXXX - Comisiones INI
			BigDecimal comiSaldoAbonoFinalOBL = new BigDecimal("0.00");
			BigDecimal comiMixRiaAbonoFinalOBL = new BigDecimal("0.00");
			BigDecimal comiFluRiaAbonoFinalOBL = new BigDecimal("0.00");
			//BigDecimal comiSaldoCargoFinalOBL = new BigDecimal("0.00");
			BigDecimal comiMixRiaCargoFinalOBL = new BigDecimal("0.00");
			BigDecimal comiFluRiaCargoFinalOBL = new BigDecimal("0.00");
			BigDecimal comiSaldoAbonoFinalVCF = new BigDecimal("0.00");
			BigDecimal comiSaldoAbonoFinalVSF = new BigDecimal("0.00");
			//BigDecimal comiMixRiaAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal comiFluRiaAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal comiSaldoCargoFinalVCF = new BigDecimal("0.00");
			//BigDecimal comiMixRiaCargoFinalVCF = new BigDecimal("0.00");
			//BigDecimal comiFluRiaCargoFinalVCF = new BigDecimal("0.00");
			BigDecimal seguNominAbonoFinalOBL = new BigDecimal("0.00");
			BigDecimal seguIntereAbonoFinalOBL = new BigDecimal("0.00");
			BigDecimal seguNominCargoFinalOBL = new BigDecimal("0.00");
			BigDecimal seguIntereCargoFinalOBL = new BigDecimal("0.00");
			//BigDecimal seguNominAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal seguIntereAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal seguNominCargoFinalVCF = new BigDecimal("0.00");
			//BigDecimal seguIntereCargoFinalVCF = new BigDecimal("0.00");
			//BigDecimal inteSaldoAbonoFinalOBL = new BigDecimal("0.00");
			BigDecimal inteMixRiaAbonoFinalOBL = new BigDecimal("0.00");
			BigDecimal inteFluRiaAbonoFinalOBL = new BigDecimal("0.00");
			//BigDecimal inteSaldoCargoFinalOBL = new BigDecimal("0.00");
			BigDecimal inteMixRiaCargoFinalOBL = new BigDecimal("0.00");
			BigDecimal inteFluRiaCargoFinalOBL = new BigDecimal("0.00");
			//BigDecimal inteSaldoAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal inteMixRiaAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal inteFluRiaAbonoFinalVCF = new BigDecimal("0.00");
			//BigDecimal inteSaldoCargoFinalVCF = new BigDecimal("0.00");
			//BigDecimal inteMixRiaCargoFinalVCF = new BigDecimal("0.00");
			//BigDecimal inteFluRiaCargoFinalVCF = new BigDecimal("0.00");
			// OTXXXXX - Comisiones FIN

			if (flag.equals(Constantes.FLAG_PERIODO)) { // 01 - CONSULTA POR RANGO DE PERIODOS
				double abono5Obl = 0;
				double abono5Vcf = 0;
				double abono5Vsf = 0;
				double cargo5Obl = 0;
				double cargo5Vcf = 0;
				double cargo5Vsf = 0;
				
				double abonoAnt5Obl = 0;
				double abonoAnt5Vcf = 0;
				double abonoAnt5Vsf = 0;
				double cargoAnt5Obl = 0;
				double cargoAnt5Vcf = 0;
				double cargoAnt5Vsf = 0;
				
				double acreditacionesPeriodoInicialObl = 0;
				double acreditacionesPeriodoInicialVcf = 0;
				double acreditacionesPeriodoInicialVsf = 0;
				double cargosPeriodoInicialObl = 0;
				double cargosPeriodoInicialVcf = 0;
				double cargosPeriodoInicialVsf = 0;
				double acreditacionesPeriodoFinalObl = 0;
				double acreditacionesPeriodoFinalVcf = 0;
				double acreditacionesPeriodoFinalVsf = 0;
				double cargosPeriodoFinalObl = 0;
				double cargosPeriodoFinalVcf = 0;
				double cargosPeriodoFinalVsf = 0;
				
				if (lstRentabilidad != null && lstRentabilidad.size() > 1) {
					Rentabilidad rentabilidadAnterior = lstRentabilidad.get(0);
					//Rentabilidad rentabilidadInicial = lstRentabilidad.get(1);
					Rentabilidad rentabilidadFinal = lstRentabilidad.get(lstRentabilidad.size() - 1);
					tieneRena04 = true;
					
					if (!rentabilidadFinal.getFlgErrorObl().equals("0")) {
						tieneErrorRenaObl = true;
					}
					if (!rentabilidadFinal.getFlgErrorVcf().equals("0")) {
						tieneErrorRenaVcf = true;
					}
					if (!rentabilidadFinal.getFlgErrorVsf().equals("0")) {
						tieneErrorRenaVsf = true;
					}
					
					Calendar inicio = new GregorianCalendar();
		            Calendar fin = new GregorianCalendar();
		            String periodoInicio = rentabilidadAnterior.getPeriodo() + "01";
		            String periodoFin = rentabilidadFinal.getPeriodo() + "01";
		            inicio.setTime(new SimpleDateFormat("yyyyMMdd").parse(periodoInicio));
		            fin.setTime(new SimpleDateFormat("yyyyMMdd").parse(periodoFin));
		            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
		            int diferenciaPeriodo = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
					
					//int diferenciaPeriodo = Integer.parseInt(rentabilidadFinal.getPeriodo().substring(4, 6)) - Integer.parseInt(rentabilidadAnterior.getPeriodo().substring(4, 6));

					tipoFondoObl = rentabilidadFinal.getFondo_OBL();
					tipoFondoVcf = rentabilidadFinal.getFondo_VCF();
					tipoFondoVsf = rentabilidadFinal.getFondo_VSF();
					
					if (lstValoresCuotaInicial != null && lstValoresCuotaInicial.size() > 1) {
						for (int i = 0; i< lstValoresCuotaInicial.size(); i++) {
							Ifdar7 valorCuota = lstValoresCuotaInicial.get(i);
							if (valorCuota.getFondo().trim().equals(rentabilidadAnterior.getFondo_OBL())) {
								valorCuotaInicialObl = valorCuota.getValorCuota();
							} 
							
							if (valorCuota.getFondo().trim().equals(rentabilidadAnterior.getFondo_VCF())) {
								valorCuotaInicialVcf = valorCuota.getValorCuota();
							} 
							
							if (valorCuota.getFondo().trim().equals(rentabilidadAnterior.getFondo_VSF())) {
								valorCuotaInicialVsf = valorCuota.getValorCuota();
							}
						}
					}
						
					if (lstValoresCuotaFinal != null && lstValoresCuotaFinal.size() > 1) {
						for (int i = 0; i< lstValoresCuotaFinal.size(); i++) {
							Ifdar7 valorCuota = lstValoresCuotaFinal.get(i);
							if (valorCuota.getFondo().trim().equals(tipoFondoObl)) {
								valorCuotaFinalObl = valorCuota.getValorCuota();
							} 
							
							if (valorCuota.getFondo().trim().equals(tipoFondoVcf)) {
								valorCuotaFinalVcf = valorCuota.getValorCuota();
							} 
								
							if (valorCuota.getFondo().trim().equals(tipoFondoVsf)) {
								valorCuotaFinalVsf = valorCuota.getValorCuota();
							}
						}
					}
					
					cuotasObl = rentabilidadFinal.getCuotasObl();
					cuotasVcf = rentabilidadFinal.getCuotasVcf();
					cuotasVsf = rentabilidadFinal.getCuotasVsf();
					
					abonoAnt5Vsf = rentabilidadAnterior.getAbono_17();
					cargoAnt5Vsf = rentabilidadAnterior.getCargo_17();
					abono5Vsf = rentabilidadFinal.getAbono_17();
					cargo5Vsf = rentabilidadFinal.getCargo_17();
					
					if (!tieneEtrarc) {
						abono5Obl = rentabilidadFinal.getAbono_5();
						abono5Vcf = rentabilidadFinal.getAbono_11();
						cargo5Obl = rentabilidadFinal.getCargo_5();
						cargo5Vcf = rentabilidadFinal.getCargo_11();
						
						abonoAnt5Obl = rentabilidadAnterior.getAbono_5();
						abonoAnt5Vcf = rentabilidadAnterior.getAbono_11();
						cargoAnt5Obl = rentabilidadAnterior.getCargo_5();
						cargoAnt5Vcf = rentabilidadAnterior.getCargo_11();
					} else {
						if (!etrarc.getFlagCargaRenta().equals("1")) {
							abono5Obl = rentabilidadFinal.getAbono_5();
							abono5Vcf = rentabilidadFinal.getAbono_11();
							cargo5Obl = rentabilidadFinal.getCargo_5();
							cargo5Vcf = rentabilidadFinal.getCargo_11();
							
							abonoAnt5Obl = rentabilidadAnterior.getAbono_5();
							abonoAnt5Vcf = rentabilidadAnterior.getAbono_11();
							cargoAnt5Obl = rentabilidadAnterior.getCargo_5();
							cargoAnt5Vcf = rentabilidadAnterior.getCargo_11();
						}
					}
					
					if (rentabilidadFinal.getAbono_5() > 0) {
						tieneTraspasoObl = true;
					}
					
					if (rentabilidadFinal.getAbono_11() > 0) {
						tieneTraspasoVcf = true;
					}
					
					if (rentabilidadFinal.getAbono_17() > 0) {
						tieneTraspasoVsf = true;
					}
					
					acreditacionesFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + abono5Obl + acreditacionesEtarcObl;
					cargosFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + Math.abs(cargo5Obl) + cargosEtarcObl;
					acreditacionesFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + abono5Vcf + acreditacionesEtarcVcf;
					cargosFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + Math.abs(cargo5Vcf) + cargosEtarcVcf;
					acreditacionesFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + abono5Vsf + acreditacionesEtarcVsf;
					cargosFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + Math.abs(cargo5Vsf) + cargosEtarcVsf;
					
					acreditacionesInicialObl = rentabilidadAnterior.getAbono_1() + rentabilidadAnterior.getAbono_2() + rentabilidadAnterior.getAbono_3();
					cargosInicialObl = Math.abs(rentabilidadAnterior.getCargo_1()) + Math.abs(rentabilidadAnterior.getCargo_3());
					acreditacionesInicialVcf = rentabilidadAnterior.getAbono_7() + rentabilidadAnterior.getAbono_8();
					cargosInicialVcf = Math.abs(rentabilidadAnterior.getCargo_7()) + Math.abs(rentabilidadAnterior.getCargo_9());
					acreditacionesInicialVsf = rentabilidadAnterior.getAbono_13() + rentabilidadAnterior.getAbono_14() + rentabilidadAnterior.getAbono_15();
					cargosInicialVsf = Math.abs(rentabilidadAnterior.getCargo_13()) + Math.abs(rentabilidadAnterior.getCargo_15());
					
					acreditacionesPeriodoFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3();
					cargosPeriodoFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3());
					acreditacionesPeriodoFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8();
					cargosPeriodoFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9());
					acreditacionesPeriodoFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15();
					cargosPeriodoFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15());
					
					acreditacionesPeriodoInicialObl = rentabilidadAnterior.getAbono_1() + rentabilidadAnterior.getAbono_2() + rentabilidadAnterior.getAbono_3();
					cargosPeriodoInicialObl = Math.abs(rentabilidadAnterior.getCargo_1()) + Math.abs(rentabilidadAnterior.getCargo_3());
					acreditacionesPeriodoInicialVcf = rentabilidadAnterior.getAbono_7() + rentabilidadAnterior.getAbono_8();
					cargosPeriodoInicialVcf = Math.abs(rentabilidadAnterior.getCargo_7()) + Math.abs(rentabilidadAnterior.getCargo_9());
					acreditacionesPeriodoInicialVsf = rentabilidadAnterior.getAbono_13() + rentabilidadAnterior.getAbono_14() + rentabilidadAnterior.getAbono_15();
					cargosPeriodoInicialVsf = Math.abs(rentabilidadAnterior.getCargo_13()) + Math.abs(rentabilidadAnterior.getCargo_15());
					
					saldoAfectoObl = rentabilidadFinal.getSaldoAfecto_OBL();
					saldoAfectoVcf = rentabilidadFinal.getSaldoAfecto_VCF();
					saldoAfectoVsf = rentabilidadFinal.getSaldoAfecto_VSF();
					saldoInafectoObl = rentabilidadFinal.getSaldoInafecto_OBL();
					saldoInafectoVcf = rentabilidadFinal.getSaldoInafecto_VCF();
					saldoInafectoVsf = rentabilidadFinal.getSaldoInafecto_VSF();
					
					saldoInicialObl = (rentabilidadAnterior.getCuotasObl()) * valorCuotaInicialObl;
					saldoInicialVcf = (rentabilidadAnterior.getCuotasVcf()) * valorCuotaInicialVcf;
					saldoInicialVsf = (rentabilidadAnterior.getCuotasVsf()) * valorCuotaInicialVsf;
					
					saldoFinalObl = rentabilidadFinal.getCuotasObl() * rentabilidadFinal.getValorCuotaObl();
					saldoFinalVcf = rentabilidadFinal.getCuotasVcf() * rentabilidadFinal.getValorCuotaVcf();
					saldoFinalVsf = rentabilidadFinal.getCuotasVsf() * rentabilidadFinal.getValorCuotaVsf();
					
					rentabilidadPeriodoInicialObl = saldoInicialObl - (acreditacionesInicialObl + cargosInicialObl - abonoAnt5Obl + cargoAnt5Obl);
					rentabilidadPeriodoInicialVcf = saldoInicialVcf - (acreditacionesInicialVcf + cargosInicialVcf - abonoAnt5Vcf + cargoAnt5Vcf);
					rentabilidadPeriodoInicialVsf = saldoInicialVsf - (acreditacionesInicialVsf + cargosInicialVsf - abonoAnt5Vsf + cargoAnt5Vsf);
						
					rentabilidadPeriodoFinalObl = saldoFinalObl - (acreditacionesFinalObl - acreditacionesEtarcObl + cargosFinalObl - cargosEtarcObl);
					rentabilidadPeriodoFinalVcf = saldoFinalVcf - (acreditacionesFinalVcf - acreditacionesEtarcVcf + cargosFinalVcf - cargosEtarcVcf);
					rentabilidadPeriodoFinalVsf = saldoFinalVsf - (acreditacionesFinalVsf - acreditacionesEtarcVsf + cargosFinalVsf - cargosEtarcVsf);

					saldoCicObl = saldoFinalObl;
					saldoCicVcf = saldoFinalVcf;
					saldoCicVsf = saldoFinalVsf;
						
					rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
					rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
					rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;

					rentabilidadObl = saldoFinalObl - ((acreditacionesFinalObl) - (cargosFinalObl));
					rentabilidadVcf = saldoFinalVcf - ((acreditacionesFinalVcf) - (cargosFinalVcf));
					rentabilidadVsf = saldoFinalVsf - ((acreditacionesFinalVsf) - (cargosFinalVsf));
						
					//Determinar si tiene periodo inicial
					// 1. Determinar si tiene periodo inicial (si tiene periodo inicial deberà de traer 5 registros)
					rentabilidadPeriodoFinalObl = saldoFinalObl - acreditacionesPeriodoFinalObl + cargosPeriodoFinalObl;
					rentabilidadPeriodoFinalVcf = saldoFinalVcf - acreditacionesPeriodoFinalVcf + cargosPeriodoFinalVcf;
					rentabilidadPeriodoFinalVsf = saldoFinalVsf - acreditacionesPeriodoFinalVsf + cargosPeriodoFinalVsf;
					
					Calendar inicio2 = new GregorianCalendar();
		            Calendar fin2 = new GregorianCalendar();
		            String periodoInicio2 = fechaInicio + "01";
		            String periodoFin2 = fechaFin + "01";
		            inicio2.setTime(new SimpleDateFormat("yyyyMMdd").parse(periodoInicio2));
		            fin2.setTime(new SimpleDateFormat("yyyyMMdd").parse(periodoFin2));
		            int difA2 = fin2.get(Calendar.YEAR) - inicio2.get(Calendar.YEAR);
		            int diferenciaPeriodo2 = difA2 * 12 + fin2.get(Calendar.MONTH) - inicio2.get(Calendar.MONTH);
					
					if ((diferenciaPeriodo == diferenciaPeriodo2 + 1) && !rentabilidadAnterior.getFondo_OBL().toUpperCase().equals("X")) {
						rentabilidadPeriodoInicialObl = saldoInicialObl - acreditacionesPeriodoInicialObl + cargosPeriodoInicialObl;
					} else {
						rentabilidadPeriodoInicialObl = rentabilidadAnterior.getAbono_5() + abono_5;
					}
					if ((diferenciaPeriodo == diferenciaPeriodo2 + 1) && !rentabilidadAnterior.getFondo_VCF().toUpperCase().equals("X")) {
						rentabilidadPeriodoInicialVcf = saldoInicialVcf - acreditacionesPeriodoInicialVcf + cargosPeriodoInicialVcf;
					} else {
						rentabilidadPeriodoInicialVcf = rentabilidadAnterior.getAbono_11() + abono_11;
					}
					if ((diferenciaPeriodo == diferenciaPeriodo2 + 1) && !rentabilidadAnterior.getFondo_VSF().toUpperCase().equals("X")) {
						rentabilidadPeriodoInicialVsf = saldoInicialVsf - acreditacionesPeriodoInicialVsf + cargosPeriodoInicialVsf;
					} else {
						rentabilidadPeriodoInicialVsf = rentabilidadAnterior.getAbono_17() + abono_17;
					}
						
					rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
					rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
					rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;
					
					// Si no hubo movimientos, adicionalmente se verifica si tiene alguno de los productos de la tabla de rentabilidad
					if (!rentabilidadFinal.getFondo_OBL().trim().equals("0")) {
						tieneObl = true;
					}
					if (!rentabilidadFinal.getFondo_VCF().trim().equals("0")) {
						tieneVcf = true;
					}
					if (!rentabilidadFinal.getFondo_VSF().trim().equals("0")) {
						tieneVsf = true;
					}
					
					// OTXXXXX - Comisiones INI
					comiSaldoAbonoFinalOBL = rentabilidadFinal.getComiSaldoAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getComiSaldoAbonoOBL().toString()));
					comiMixRiaAbonoFinalOBL = rentabilidadFinal.getComiMixRiaAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getComiMixRiaAbonoOBL().toString()));
					comiFluRiaAbonoFinalOBL = rentabilidadFinal.getComiFluRiaAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getComiFluRiaAbonoOBL().toString()));
					//comiSaldoCargoFinalOBL = rentabilidadFinal.getComiSaldoCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getComiSaldoCargoOBL().toString()));
					comiMixRiaCargoFinalOBL = rentabilidadFinal.getComiMixRiaCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getComiMixRiaCargoOBL().toString()));
					comiFluRiaCargoFinalOBL = rentabilidadFinal.getComiFluRiaCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getComiFluRiaCargoOBL().toString()));
					comiSaldoAbonoFinalVCF = rentabilidadFinal.getComiSaldoAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getComiSaldoAbonoVCF().toString()));
					//comiMixRiaAbonoFinalVCF = rentabilidadFinal.getComiMixRiaAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getComiMixRiaAbonoVCF().toString()));
					//comiFluRiaAbonoFinalVCF = rentabilidadFinal.getComiFluRiaAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getComiFluRiaAbonoVCF().toString()));
					//comiSaldoCargoFinalVCF = rentabilidadFinal.getComiSaldoCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getComiSaldoCargoVCF().toString()));
					//comiMixRiaCargoFinalVCF = rentabilidadFinal.getComiMixRiaCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getComiMixRiaCargoVCF().toString()));
					//comiFluRiaCargoFinalVCF = rentabilidadFinal.getComiFluRiaCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getComiFluRiaCargoVCF().toString()));
					seguNominAbonoFinalOBL = rentabilidadFinal.getSeguNominAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getSeguNominAbonoOBL().toString()));
					seguIntereAbonoFinalOBL = rentabilidadFinal.getSeguIntereAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getSeguIntereAbonoOBL().toString()));
					seguNominCargoFinalOBL = rentabilidadFinal.getSeguNominCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getSeguNominCargoOBL().toString()));
					seguIntereCargoFinalOBL = rentabilidadFinal.getSeguIntereCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getSeguIntereCargoOBL().toString()));
					//seguNominAbonoFinalVCF = rentabilidadFinal.getSeguNominAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getSeguNominAbonoVCF().toString()));
					//seguIntereAbonoFinalVCF = rentabilidadFinal.getSeguIntereAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getSeguIntereAbonoVCF().toString()));
					//seguNominCargoFinalVCF = rentabilidadFinal.getSeguNominCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getSeguNominCargoVCF().toString()));
					//seguIntereCargoFinalVCF = rentabilidadFinal.getSeguIntereCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getSeguIntereCargoVCF().toString()));
					
					//inteSaldoAbonoFinalOBL = rentabilidadFinal.getInteSaldoAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getInteSaldoAbonoOBL().toString()));
					inteMixRiaAbonoFinalOBL = rentabilidadFinal.getInteMixRiaAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getInteMixRiaAbonoOBL().toString()));
					inteFluRiaAbonoFinalOBL = rentabilidadFinal.getInteFluRiaAbonoOBL().subtract(new BigDecimal(rentabilidadAnterior.getInteFluRiaAbonoOBL().toString()));
					//inteSaldoCargoFinalOBL = rentabilidadFinal.getInteSaldoCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getInteSaldoCargoOBL().toString()));
					inteMixRiaCargoFinalOBL = rentabilidadFinal.getInteMixRiaCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getInteMixRiaCargoOBL().toString()));
					inteFluRiaCargoFinalOBL = rentabilidadFinal.getInteFluRiaCargoOBL().subtract(new BigDecimal(rentabilidadAnterior.getInteFluRiaCargoOBL().toString()));
					//inteSaldoAbonoFinalVCF = rentabilidadFinal.getInteSaldoAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getInteSaldoAbonoVCF().toString()));
					//inteMixRiaAbonoFinalVCF = rentabilidadFinal.getInteMixRiaAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getInteMixRiaAbonoVCF().toString()));
					//inteFluRiaAbonoFinalVCF = rentabilidadFinal.getInteFluRiaAbonoVCF().subtract(new BigDecimal(rentabilidadAnterior.getInteFluRiaAbonoVCF().toString()));
					//inteSaldoCargoFinalVCF = rentabilidadFinal.getInteSaldoCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getInteSaldoCargoVCF().toString()));
					//inteMixRiaCargoFinalVCF = rentabilidadFinal.getInteMixRiaCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getInteMixRiaCargoVCF().toString()));
					//inteFluRiaCargoFinalVCF = rentabilidadFinal.getInteFluRiaCargoVCF().subtract(new BigDecimal(rentabilidadAnterior.getInteFluRiaCargoVCF().toString()));
					// OTXXXXX - Comisiones FIN
				} else {
					if (lstRentabilidad != null && lstRentabilidad.size() == 1) {
						Rentabilidad rentabilidadFinal = lstRentabilidad.get(0);

						//----------------------------------------------------------------------------------------------------------------
						//----------------------------------------------------------------------------------------------------------------
						tipoFondoObl = rentabilidadFinal.getFondo_OBL();
						tipoFondoVcf = rentabilidadFinal.getFondo_VCF();
						tipoFondoVsf = rentabilidadFinal.getFondo_VSF();
						
						if (lstValoresCuotaFinal != null && lstValoresCuotaFinal.size() > 1) {
							for (int i = 0; i< lstValoresCuotaFinal.size(); i++) {
								Ifdar7 valorCuota = lstValoresCuotaFinal.get(i);
								if (valorCuota.getFondo().trim().equals(tipoFondoObl)) {
									valorCuotaFinalObl = valorCuota.getValorCuota();
								} 
								
								if (valorCuota.getFondo().trim().equals(tipoFondoVcf)) {
									valorCuotaFinalVcf = valorCuota.getValorCuota();
								} 
									
								if (valorCuota.getFondo().trim().equals(tipoFondoVsf)) {
									valorCuotaFinalVsf = valorCuota.getValorCuota();
								}
							}
						}
						
						if (!rentabilidadFinal.getFlgErrorObl().equals("0")) {
							tieneErrorRenaObl = true;
						}
						if (!rentabilidadFinal.getFlgErrorVcf().equals("0")) {
							tieneErrorRenaVcf = true;
						}
						if (!rentabilidadFinal.getFlgErrorVsf().equals("0")) {
							tieneErrorRenaVsf = true;
						}

						cuotasObl = rentabilidadFinal.getCuotasObl();
						cuotasVcf = rentabilidadFinal.getCuotasVcf();
						cuotasVsf = rentabilidadFinal.getCuotasVsf();

						abono5Vsf = rentabilidadFinal.getAbono_17();
						cargo5Vsf = rentabilidadFinal.getCargo_17();
						
						if (!tieneEtrarc) {
							abono5Obl = rentabilidadFinal.getAbono_5() + abono_5;
							abono5Vcf = rentabilidadFinal.getAbono_11() + abono_11;
							cargo5Obl = rentabilidadFinal.getCargo_5() + Math.abs(cargo_5);
							cargo5Vcf = rentabilidadFinal.getCargo_11() + Math.abs(cargo_11);
						} else {
							if (!etrarc.getFlagCargaRenta().equals("1")) {
								abono5Obl = rentabilidadFinal.getAbono_5() + abono_5;
								abono5Vcf = rentabilidadFinal.getAbono_11() + abono_11;
								cargo5Obl = rentabilidadFinal.getCargo_5() + Math.abs(cargo_5);
								cargo5Vcf = rentabilidadFinal.getCargo_11() + Math.abs(cargo_11);
							}
						}
						
						acreditacionesFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + (abono_1 + abono_2 + abono_3) + abono5Obl + acreditacionesEtarcObl;
						cargosFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + (Math.abs(cargo_1) + Math.abs(cargo_3)) + Math.abs(cargo5Obl) + cargosEtarcObl;
						acreditacionesFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + (abono_7 + abono_8) + abono5Vcf + acreditacionesEtarcVcf;
						cargosFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + (Math.abs(cargo_7) + Math.abs(cargo_9)) + Math.abs(cargo5Vcf) + cargosEtarcVcf;
						acreditacionesFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + (abono_13 + abono_14 + abono_15) + abono5Vsf + acreditacionesEtarcVsf;
						cargosFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + (Math.abs(cargo_13) + Math.abs(cargo_15)) + Math.abs(cargo5Vsf) + cargosEtarcVsf;

						acreditacionesPeriodoFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + (abono_1 + abono_2 + abono_3);
						cargosPeriodoFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + (Math.abs(cargo_1) + Math.abs(cargo_3));
						acreditacionesPeriodoFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + (abono_7 + abono_8);
						cargosPeriodoFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + (Math.abs(cargo_7) + Math.abs(cargo_9));
						acreditacionesPeriodoFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + (abono_13 + abono_14 + abono_15);
						cargosPeriodoFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + (Math.abs(cargo_13) + Math.abs(cargo_15));

						saldoAfectoObl = rentabilidadFinal.getSaldoAfecto_OBL();
						saldoAfectoVcf = rentabilidadFinal.getSaldoAfecto_VCF();
						saldoAfectoVsf = rentabilidadFinal.getSaldoAfecto_VSF();
						saldoInafectoObl = rentabilidadFinal.getSaldoInafecto_OBL();
						saldoInafectoVcf = rentabilidadFinal.getSaldoInafecto_VCF();
						saldoInafectoVsf = rentabilidadFinal.getSaldoInafecto_VSF();

						saldoFinalObl = (cuotasObl) * valorCuotaFinalObl;
						saldoFinalVcf = (cuotasVcf) * valorCuotaFinalVcf;
						saldoFinalVsf = (cuotasVsf) * valorCuotaFinalVsf;

	 					saldoCicObl = saldoFinalObl;
						saldoCicVcf = saldoFinalVcf;
						saldoCicVsf = saldoFinalVsf;
						
						rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
						rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
						rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;

						rentabilidadObl = saldoFinalObl - ((acreditacionesFinalObl) - (cargosFinalObl));
						rentabilidadVcf = saldoFinalVcf - ((acreditacionesFinalVcf) - (cargosFinalVcf));
						rentabilidadVsf = saldoFinalVsf - ((acreditacionesFinalVsf) - (cargosFinalVsf));
						
						//Determinar si tiene periodo inicial
						// 1. Determinar si tiene periodo inicial (si tiene periodo inicial deberà de traer 5 registros)
						rentabilidadPeriodoFinalObl = saldoFinalObl - acreditacionesPeriodoFinalObl + cargosPeriodoFinalObl;
						rentabilidadPeriodoFinalVcf = saldoFinalVcf - acreditacionesPeriodoFinalVcf + cargosPeriodoFinalVcf;
						rentabilidadPeriodoFinalVsf = saldoFinalVsf - acreditacionesPeriodoFinalVsf + cargosPeriodoFinalVsf;
						
						rentabilidadPeriodoInicialObl = rentabilidadFinal.getAbono_5() + abono_5;
						rentabilidadPeriodoInicialVcf = rentabilidadFinal.getAbono_11() + abono_11;
						rentabilidadPeriodoInicialVsf = rentabilidadFinal.getAbono_17() + abono_17;
						
						rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
						rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
						rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;
						
						// OTXXXXX - Comisiones INI
						comiSaldoAbonoFinalOBL = rentabilidadFinal.getComiSaldoAbonoOBL();
						comiMixRiaAbonoFinalOBL = rentabilidadFinal.getComiMixRiaAbonoOBL();
						comiFluRiaAbonoFinalOBL = rentabilidadFinal.getComiFluRiaAbonoOBL();
						//comiSaldoCargoFinalOBL = rentabilidadFinal.getComiSaldoCargoOBL();
						comiMixRiaCargoFinalOBL = rentabilidadFinal.getComiMixRiaCargoOBL();
						comiFluRiaCargoFinalOBL = rentabilidadFinal.getComiFluRiaCargoOBL();
						comiSaldoAbonoFinalVCF = rentabilidadFinal.getComiSaldoAbonoVCF();
						//comiMixRiaAbonoFinalVCF = rentabilidadFinal.getComiMixRiaAbonoVCF();
						//comiFluRiaAbonoFinalVCF = rentabilidadFinal.getComiFluRiaAbonoVCF();
						//comiSaldoCargoFinalVCF = rentabilidadFinal.getComiSaldoCargoVCF();
						//comiMixRiaCargoFinalVCF = rentabilidadFinal.getComiMixRiaCargoVCF();
						//comiFluRiaCargoFinalVCF = rentabilidadFinal.getComiFluRiaCargoVCF();
						seguNominAbonoFinalOBL = rentabilidadFinal.getSeguNominAbonoOBL();
						seguIntereAbonoFinalOBL = rentabilidadFinal.getSeguIntereAbonoOBL();
						seguNominCargoFinalOBL = rentabilidadFinal.getSeguNominCargoOBL();
						seguIntereCargoFinalOBL = rentabilidadFinal.getSeguIntereCargoOBL();
						//seguNominAbonoFinalVCF = rentabilidadFinal.getSeguNominAbonoVCF();
						//seguIntereAbonoFinalVCF = rentabilidadFinal.getSeguIntereAbonoVCF();
						//seguNominCargoFinalVCF = rentabilidadFinal.getSeguNominCargoVCF();
						//seguIntereCargoFinalVCF = rentabilidadFinal.getSeguIntereCargoVCF();
						
						//inteSaldoAbonoFinalOBL = rentabilidadFinal.getInteSaldoAbonoOBL();
						inteMixRiaAbonoFinalOBL = rentabilidadFinal.getInteMixRiaAbonoOBL();
						inteFluRiaAbonoFinalOBL = rentabilidadFinal.getInteFluRiaAbonoOBL();
						//inteSaldoCargoFinalOBL = rentabilidadFinal.getInteSaldoCargoOBL();
						inteMixRiaCargoFinalOBL = rentabilidadFinal.getInteMixRiaCargoOBL();
						inteFluRiaCargoFinalOBL = rentabilidadFinal.getInteFluRiaCargoOBL();
						//inteSaldoAbonoFinalVCF = rentabilidadFinal.getInteSaldoAbonoVCF();
						//inteMixRiaAbonoFinalVCF = rentabilidadFinal.getInteMixRiaAbonoVCF();
						//inteFluRiaAbonoFinalVCF = rentabilidadFinal.getInteFluRiaAbonoVCF();
						//inteSaldoCargoFinalVCF = rentabilidadFinal.getInteSaldoCargoVCF();
						//inteMixRiaCargoFinalVCF = rentabilidadFinal.getInteMixRiaCargoVCF();
						//inteFluRiaCargoFinalVCF = rentabilidadFinal.getInteFluRiaCargoVCF();
						// OTXXXXX - Comisiones FIN
						
						//----------------------------------------------------------------------------------------------------------------
						//----------------------------------------------------------------------------------------------------------------
					} else {
						tipoFondoObl = "";
						tipoFondoVcf = "";
						tipoFondoVsf = "";
						saldoAfectoObl = 0;
						saldoAfectoVcf = 0;
						saldoAfectoVsf = 0;
						saldoInafectoObl = 0;
						saldoInafectoVcf = 0;
						saldoInafectoVsf = 0;
						tieneObl = false;
						tieneVcf = false;
						tieneVsf = false;
					}
				}
			} else { // 02 - CONSULTA POR FECHA PUNTUAL
				tipoFondoObl = "";
				tipoFondoVcf = "";
				tipoFondoVsf = "";

				double abono5Obl = 0;
				double abono5Vcf = 0;
				double abono5Vsf = 0;
				double cargo5Obl = 0;
				double cargo5Vcf = 0;
				double cargo5Vsf = 0;
				
				double abonoAnt5Obl = 0;
				double abonoAnt5Vcf = 0;
				double abonoAnt5Vsf = 0;
				double cargoAnt5Obl = 0;
				double cargoAnt5Vcf = 0;
				double cargoAnt5Vsf = 0;
				
				double acreditacionesPeriodoFinalObl = 0;
				double acreditacionesPeriodoFinalVcf = 0;
				double acreditacionesPeriodoFinalVsf = 0;
				double cargosPeriodoFinalObl = 0;
				double cargosPeriodoFinalVcf = 0;
				double cargosPeriodoFinalVsf = 0;

				if (lstRentabilidad != null && lstRentabilidad.size() > 1) {
					Rentabilidad rentabilidadAnterior = lstRentabilidad.get(0);
					//Rentabilidad rentabilidadInicial = lstRentabilidad.get(1);
					Rentabilidad rentabilidadFinal = lstRentabilidad.get(lstRentabilidad.size() - 1);
					
					tieneRena04 = true;
					
					if (!rentabilidadFinal.getFlgErrorObl().equals("0")) {
						tieneErrorRenaObl = true;
					}
					if (!rentabilidadFinal.getFlgErrorVcf().equals("0")) {
						tieneErrorRenaVcf = true;
					}
					if (!rentabilidadFinal.getFlgErrorVsf().equals("0")) {
						tieneErrorRenaVsf = true;
					}
					
					tipoFondoObl = devolverTipoFondo(rentabilidadFinal.getFondo_OBL(), lstFondoMovimientoObl); //rentabilidadFinal.getFondo_OBL();
					tipoFondoVcf = devolverTipoFondo(rentabilidadFinal.getFondo_VCF(), lstFondoMovimientoVcf); //rentabilidadFinal.getFondo_VCF();
					tipoFondoVsf = devolverTipoFondo(rentabilidadFinal.getFondo_VSF(), lstFondoMovimientoVsf); //rentabilidadFinal.getFondo_VSF();
					
					if (lstValoresCuotaInicial != null && lstValoresCuotaInicial.size() > 1) {
						for (int i = 0; i< lstValoresCuotaInicial.size(); i++) {
							Ifdar7 valorCuota = lstValoresCuotaInicial.get(i);
							if (valorCuota.getFondo().trim().equals(rentabilidadAnterior.getFondo_OBL())) {
								valorCuotaInicialObl = valorCuota.getValorCuota();
							} 
							
							if (valorCuota.getFondo().trim().equals(rentabilidadAnterior.getFondo_VCF())) {
								valorCuotaInicialVcf = valorCuota.getValorCuota();
							} 
							
							if (valorCuota.getFondo().trim().equals(rentabilidadAnterior.getFondo_VSF())) {
								valorCuotaInicialVsf = valorCuota.getValorCuota();
							}
						}
					}
						
					if (lstValoresCuotaFinal != null && lstValoresCuotaFinal.size() > 1) {
						for (int i = 0; i< lstValoresCuotaFinal.size(); i++) {
							Ifdar7 valorCuota = lstValoresCuotaFinal.get(i);
							if (valorCuota.getFondo().trim().equals(tipoFondoObl)) {
								valorCuotaFinalObl = valorCuota.getValorCuota();
							} 
							
							if (valorCuota.getFondo().trim().equals(tipoFondoVcf)) {
								valorCuotaFinalVcf = valorCuota.getValorCuota();
							} 
								
							if (valorCuota.getFondo().trim().equals(tipoFondoVsf)) {
								valorCuotaFinalVsf = valorCuota.getValorCuota();
							}
						}
					}

					Calendar inicio = new GregorianCalendar();
		            Calendar fin = new GregorianCalendar();
		            String periodoInicio = rentabilidadAnterior.getPeriodo() + "01";
		            String periodoFin = rentabilidadFinal.getPeriodo() + "01";
		            inicio.setTime(new SimpleDateFormat("yyyyMMdd").parse(periodoInicio));
		            fin.setTime(new SimpleDateFormat("yyyyMMdd").parse(periodoFin));
		            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
		            int diferenciaPeriodo = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
					
					//int diferenciaPeriodo = Integer.parseInt(rentabilidadFinal.getPeriodo().substring(4, 6)) - Integer.parseInt(rentabilidadAnterior.getPeriodo().substring(4, 6));
					
					cuotasObl = cuotasObl + rentabilidadFinal.getCuotasObl();
					cuotasVcf = cuotasVcf + rentabilidadFinal.getCuotasVcf();
					cuotasVsf = cuotasVsf + rentabilidadFinal.getCuotasVsf();

					abonoAnt5Vsf = rentabilidadAnterior.getAbono_17();
					cargoAnt5Vsf = rentabilidadAnterior.getCargo_17();
					abono5Vsf = rentabilidadFinal.getAbono_17();
					cargo5Vsf = rentabilidadFinal.getCargo_17();
					
					if (!tieneEtrarc) {
						abono5Obl = rentabilidadFinal.getAbono_5() + abono_5;
						abono5Vcf = rentabilidadFinal.getAbono_11() + abono_11;
						cargo5Obl = rentabilidadFinal.getCargo_5() + Math.abs(cargo_5);
						cargo5Vcf = rentabilidadFinal.getCargo_11() + Math.abs(cargo_11);
						
						abonoAnt5Obl = rentabilidadAnterior.getAbono_5();
						abonoAnt5Vcf = rentabilidadAnterior.getAbono_11();
						cargoAnt5Obl = rentabilidadAnterior.getCargo_5();
						cargoAnt5Vcf = rentabilidadAnterior.getCargo_11();
					} else {
						if (!etrarc.getFlagCargaRenta().equals("1")) {
							abono5Obl = rentabilidadFinal.getAbono_5() + abono_5;
							abono5Vcf = rentabilidadFinal.getAbono_11() + abono_11;
							cargo5Obl = rentabilidadFinal.getCargo_5() + Math.abs(cargo_5);
							cargo5Vcf = rentabilidadFinal.getCargo_11() + Math.abs(cargo_11);
							
							abonoAnt5Obl = rentabilidadAnterior.getAbono_5();
							abonoAnt5Vcf = rentabilidadAnterior.getAbono_11();
							cargoAnt5Obl = rentabilidadAnterior.getCargo_5();
							cargoAnt5Vcf = rentabilidadAnterior.getCargo_11();
						}
					}
					
					if ((rentabilidadFinal.getAbono_5() + abono_5) > 0) {
						tieneTraspasoObl = true;
					}
					
					if ((rentabilidadFinal.getAbono_11() + abono_11) > 0) {
						tieneTraspasoVcf = true;
					}
					
					if ((rentabilidadFinal.getAbono_17() + abono_17) > 0) {
						tieneTraspasoVsf = true;
					}
					
					acreditacionesFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + (abono_1 + abono_2 + abono_3) + abono5Obl + acreditacionesEtarcObl;
					cargosFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + (Math.abs(cargo_1) + Math.abs(cargo_3)) + Math.abs(cargo5Obl) + cargosEtarcObl;
					acreditacionesFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + (abono_7 + abono_8) + abono5Vcf + acreditacionesEtarcVcf;
					cargosFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + (Math.abs(cargo_7) + Math.abs(cargo_9)) + Math.abs(cargo5Vcf) + cargosEtarcVcf;
					acreditacionesFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + (abono_13 + abono_14 + abono_15) + abono5Vsf + acreditacionesEtarcVsf;
					cargosFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + (Math.abs(cargo_13) + Math.abs(cargo_15)) + Math.abs(cargo5Vsf) + cargosEtarcVsf;
					
					acreditacionesInicialObl = rentabilidadAnterior.getAbono_1() + rentabilidadAnterior.getAbono_2() + rentabilidadAnterior.getAbono_3();
					cargosInicialObl = Math.abs(rentabilidadAnterior.getCargo_1()) + Math.abs(rentabilidadAnterior.getCargo_3());
					acreditacionesInicialVcf = rentabilidadAnterior.getAbono_7() + rentabilidadAnterior.getAbono_8();
					cargosInicialVcf = Math.abs(rentabilidadAnterior.getCargo_7()) + Math.abs(rentabilidadAnterior.getCargo_9());
					acreditacionesInicialVsf = rentabilidadAnterior.getAbono_13() + rentabilidadAnterior.getAbono_14() + rentabilidadAnterior.getAbono_15();
					cargosInicialVsf = Math.abs(rentabilidadAnterior.getCargo_13()) + Math.abs(rentabilidadAnterior.getCargo_15());
					
					double acreditacionesPeriodoInicialObl = 0;
					double acreditacionesPeriodoInicialVcf = 0;
					double acreditacionesPeriodoInicialVsf = 0;
					double cargosPeriodoInicialObl = 0;
					double cargosPeriodoInicialVcf = 0;
					double cargosPeriodoInicialVsf = 0;
					
					acreditacionesPeriodoFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + (abono_1 + abono_2 + abono_3);
					cargosPeriodoFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + (Math.abs(cargo_1) + Math.abs(cargo_3));
					acreditacionesPeriodoFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + (abono_7 + abono_8);
					cargosPeriodoFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + (Math.abs(cargo_7) + Math.abs(cargo_9));
					acreditacionesPeriodoFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + (abono_13 + abono_14 + abono_15);
					cargosPeriodoFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + (Math.abs(cargo_13) + Math.abs(cargo_15));
					
					acreditacionesPeriodoInicialObl = rentabilidadAnterior.getAbono_1() + rentabilidadAnterior.getAbono_2() + rentabilidadAnterior.getAbono_3();
					cargosPeriodoInicialObl = Math.abs(rentabilidadAnterior.getCargo_1()) + Math.abs(rentabilidadAnterior.getCargo_3());
					acreditacionesPeriodoInicialVcf = rentabilidadAnterior.getAbono_7() + rentabilidadAnterior.getAbono_8();
					cargosPeriodoInicialVcf = Math.abs(rentabilidadAnterior.getCargo_7()) + Math.abs(rentabilidadAnterior.getCargo_9());
					acreditacionesPeriodoInicialVsf = rentabilidadAnterior.getAbono_13() + rentabilidadAnterior.getAbono_14() + rentabilidadAnterior.getAbono_15();
					cargosPeriodoInicialVsf = Math.abs(rentabilidadAnterior.getCargo_13()) + Math.abs(rentabilidadAnterior.getCargo_15());
					
					saldoAfectoObl = rentabilidadFinal.getSaldoAfecto_OBL();
					saldoAfectoVcf = rentabilidadFinal.getSaldoAfecto_VCF();
					saldoAfectoVsf = rentabilidadFinal.getSaldoAfecto_VSF();
					saldoInafectoObl = rentabilidadFinal.getSaldoInafecto_OBL();
					saldoInafectoVcf = rentabilidadFinal.getSaldoInafecto_VCF();
					saldoInafectoVsf = rentabilidadFinal.getSaldoInafecto_VSF();
					
					saldoInicialObl = (rentabilidadAnterior.getCuotasObl()) * valorCuotaInicialObl;
					saldoInicialVcf = (rentabilidadAnterior.getCuotasVcf()) * valorCuotaInicialVcf;
					saldoInicialVsf = (rentabilidadAnterior.getCuotasVsf()) * valorCuotaInicialVsf;
					
					saldoFinalObl = (cuotasObl) * valorCuotaFinalObl;
					saldoFinalVcf = (cuotasVcf) * valorCuotaFinalVcf;
					saldoFinalVsf = (cuotasVsf) * valorCuotaFinalVsf;

					rentabilidadPeriodoInicialObl = saldoInicialObl - (acreditacionesInicialObl + cargosInicialObl - abonoAnt5Obl + cargoAnt5Obl);
					rentabilidadPeriodoInicialVcf = saldoInicialVcf - (acreditacionesInicialVcf + cargosInicialVcf - abonoAnt5Vcf + cargoAnt5Vcf);
					rentabilidadPeriodoInicialVsf = saldoInicialVsf - (acreditacionesInicialVsf + cargosInicialVsf - abonoAnt5Vsf + cargoAnt5Vsf);
						
					rentabilidadPeriodoFinalObl = saldoFinalObl - (acreditacionesFinalObl - acreditacionesEtarcObl + cargosFinalObl - cargosEtarcObl);
					rentabilidadPeriodoFinalVcf = saldoFinalVcf - (acreditacionesFinalVcf - acreditacionesEtarcVcf + cargosFinalVcf - cargosEtarcVcf);
					rentabilidadPeriodoFinalVsf = saldoFinalVsf - (acreditacionesFinalVsf - acreditacionesEtarcVsf + cargosFinalVsf - cargosEtarcVsf);

 					saldoCicObl = saldoFinalObl;
					saldoCicVcf = saldoFinalVcf;
					saldoCicVsf = saldoFinalVsf;
					
					rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
					rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
					rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;

					rentabilidadObl = saldoFinalObl - ((acreditacionesFinalObl) - (cargosFinalObl));
					rentabilidadVcf = saldoFinalVcf - ((acreditacionesFinalVcf) - (cargosFinalVcf));
					rentabilidadVsf = saldoFinalVsf - ((acreditacionesFinalVsf) - (cargosFinalVsf));
					
					//Determinar si tiene periodo inicial
					// 1. Determinar si tiene periodo inicial (si tiene periodo inicial deberà de traer 5 registros)
					rentabilidadPeriodoFinalObl = saldoFinalObl - acreditacionesPeriodoFinalObl + cargosPeriodoFinalObl;
					rentabilidadPeriodoFinalVcf = saldoFinalVcf - acreditacionesPeriodoFinalVcf + cargosPeriodoFinalVcf;
					rentabilidadPeriodoFinalVsf = saldoFinalVsf - acreditacionesPeriodoFinalVsf + cargosPeriodoFinalVsf;
					
					if ((diferenciaPeriodo == 4 || diferenciaPeriodo == -8) && !rentabilidadAnterior.getFondo_OBL().toUpperCase().equals("X")) {
						rentabilidadPeriodoInicialObl = saldoInicialObl - acreditacionesPeriodoInicialObl + cargosPeriodoInicialObl;
						
					} else {
						rentabilidadPeriodoInicialObl = rentabilidadFinal.getAbono_5() + abono_5;
					}
					if ((diferenciaPeriodo == 4 || diferenciaPeriodo == -8) && !rentabilidadAnterior.getFondo_VCF().toUpperCase().equals("X")) {
						rentabilidadPeriodoInicialVcf = saldoInicialVcf - acreditacionesPeriodoInicialVcf + cargosPeriodoInicialVcf;
						
					} else {
						rentabilidadPeriodoInicialVcf = rentabilidadFinal.getAbono_11() + abono_11;
					}
					if ((diferenciaPeriodo == 4 || diferenciaPeriodo == -8) && !rentabilidadAnterior.getFondo_VSF().toUpperCase().equals("X")) {
						rentabilidadPeriodoInicialVsf = saldoInicialVsf - acreditacionesPeriodoInicialVsf + cargosPeriodoInicialVsf;
						
					} else {
						rentabilidadPeriodoInicialVsf = rentabilidadFinal.getAbono_17() + abono_17;
					}
					
					rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
					rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
					rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;
					
					// OTXXXXX - Comisiones INI
					comiSaldoAbonoFinalOBL = new BigDecimal(comiSaldoAbonoOBL + Math.abs(rentabilidadFinal.getComiSaldoAbonoOBL().doubleValue()) - Math.abs(rentabilidadAnterior.getComiSaldoAbonoOBL().doubleValue()));
					comiMixRiaAbonoFinalOBL = new BigDecimal(comiMixRiaAbonoOBL + rentabilidadFinal.getComiMixRiaAbonoOBL().doubleValue() - rentabilidadAnterior.getComiMixRiaAbonoOBL().doubleValue());
					comiFluRiaAbonoFinalOBL = new BigDecimal(comiFluRiaAbonoOBL + rentabilidadFinal.getComiFluRiaAbonoOBL().doubleValue() - rentabilidadAnterior.getComiFluRiaAbonoOBL().doubleValue());
					comiMixRiaCargoFinalOBL = new BigDecimal(comiMixRiaCargoOBL + rentabilidadFinal.getComiMixRiaCargoOBL().doubleValue() - rentabilidadAnterior.getComiMixRiaCargoOBL().doubleValue());
					comiFluRiaCargoFinalOBL = new BigDecimal(comiFluRiaCargoOBL + rentabilidadFinal.getComiFluRiaCargoOBL().doubleValue() - rentabilidadAnterior.getComiFluRiaCargoOBL().doubleValue());
					seguNominAbonoFinalOBL = new BigDecimal(seguNominAbonoOBL + rentabilidadFinal.getSeguNominAbonoOBL().doubleValue() - rentabilidadAnterior.getSeguNominAbonoOBL().doubleValue());
					seguIntereAbonoFinalOBL = new BigDecimal(seguIntereAbonoOBL + rentabilidadFinal.getSeguIntereAbonoOBL().doubleValue() - rentabilidadAnterior.getSeguIntereAbonoOBL().doubleValue());
					seguNominCargoFinalOBL = new BigDecimal(seguNominCargoOBL + rentabilidadFinal.getSeguNominCargoOBL().doubleValue() - rentabilidadAnterior.getSeguNominCargoOBL().doubleValue());
					seguIntereCargoFinalOBL = new BigDecimal(seguIntereCargoOBL + rentabilidadFinal.getSeguIntereCargoOBL().doubleValue() - rentabilidadAnterior.getSeguIntereCargoOBL().doubleValue());
					comiSaldoAbonoFinalVCF = new BigDecimal(comiSaldoAbonoVCF + Math.abs(rentabilidadFinal.getComiSaldoAbonoVCF().doubleValue()) - Math.abs(rentabilidadAnterior.getComiSaldoAbonoVCF().doubleValue()));
					comiSaldoAbonoFinalVSF = new BigDecimal(comiSaldoAbonoVSF + Math.abs(rentabilidadFinal.getComiSaldoAbonoVSF().doubleValue()) - Math.abs(rentabilidadAnterior.getComiSaldoAbonoVSF().doubleValue()));
					
					inteMixRiaAbonoFinalOBL = new BigDecimal(inteMixRiaAbonoOBL + rentabilidadFinal.getInteMixRiaAbonoOBL().doubleValue() - rentabilidadAnterior.getInteMixRiaAbonoOBL().doubleValue());
					inteFluRiaAbonoFinalOBL = new BigDecimal(inteFluRiaAbonoOBL + rentabilidadFinal.getInteFluRiaAbonoOBL().doubleValue() - rentabilidadAnterior.getInteFluRiaAbonoOBL().doubleValue());
					inteMixRiaCargoFinalOBL = new BigDecimal(inteMixRiaCargoOBL + rentabilidadFinal.getInteMixRiaCargoOBL().doubleValue() - rentabilidadAnterior.getInteMixRiaCargoOBL().doubleValue());
					inteFluRiaCargoFinalOBL = new BigDecimal(inteFluRiaCargoOBL + rentabilidadFinal.getInteFluRiaCargoOBL().doubleValue() - rentabilidadAnterior.getInteFluRiaCargoOBL().doubleValue());
					// OTXXXXX - Comisiones FIN
				} else {
					if (lstRentabilidad != null && lstRentabilidad.size() == 1) {
						Rentabilidad rentabilidadFinal = lstRentabilidad.get(0);
						
						tieneRena04 = true;
						
						//----------------------------------------------------------------------------------------------------------------
						//----------------------------------------------------------------------------------------------------------------
						if (!rentabilidadFinal.getFlgErrorObl().equals("0")) {
							tieneErrorRenaObl = true;
						}
						if (!rentabilidadFinal.getFlgErrorVcf().equals("0")) {
							tieneErrorRenaVcf = true;
						}
						if (!rentabilidadFinal.getFlgErrorVsf().equals("0")) {
							tieneErrorRenaVsf = true;
						}

						tipoFondoObl = devolverTipoFondo(rentabilidadFinal.getFondo_OBL(), lstFondoMovimientoObl); //rentabilidadFinal.getFondo_OBL();
						tipoFondoVcf = devolverTipoFondo(rentabilidadFinal.getFondo_VCF(), lstFondoMovimientoVcf); //rentabilidadFinal.getFondo_VCF();
						tipoFondoVsf = devolverTipoFondo(rentabilidadFinal.getFondo_VSF(), lstFondoMovimientoVsf); //rentabilidadFinal.getFondo_VSF();
							
						if (lstValoresCuotaFinal != null && lstValoresCuotaFinal.size() > 1) {
							for (int i = 0; i< lstValoresCuotaFinal.size(); i++) {
								Ifdar7 valorCuota = lstValoresCuotaFinal.get(i);
								if (valorCuota.getFondo().trim().equals(tipoFondoObl)) {
									valorCuotaFinalObl = valorCuota.getValorCuota();
								} 
								
								if (valorCuota.getFondo().trim().equals(tipoFondoVcf)) {
									valorCuotaFinalVcf = valorCuota.getValorCuota();
								} 
									
								if (valorCuota.getFondo().trim().equals(tipoFondoVsf)) {
									valorCuotaFinalVsf = valorCuota.getValorCuota();
								}
							}
						}

						cuotasObl = cuotasObl + rentabilidadFinal.getCuotasObl();
						cuotasVcf = cuotasVcf + rentabilidadFinal.getCuotasVcf();
						cuotasVsf = cuotasVsf + rentabilidadFinal.getCuotasVsf();

						abono5Vsf = rentabilidadFinal.getAbono_17();
						cargo5Vsf = rentabilidadFinal.getCargo_17();
						
						if (!tieneEtrarc) {
							abono5Obl = rentabilidadFinal.getAbono_5() + abono_5;
							abono5Vcf = rentabilidadFinal.getAbono_11() + abono_11;
							cargo5Obl = rentabilidadFinal.getCargo_5() + Math.abs(cargo_5);
							cargo5Vcf = rentabilidadFinal.getCargo_11() + Math.abs(cargo_11);
						} else {
							if (!etrarc.getFlagCargaRenta().equals("1")) {
								abono5Obl = rentabilidadFinal.getAbono_5() + abono_5;
								abono5Vcf = rentabilidadFinal.getAbono_11() + abono_11;
								cargo5Obl = rentabilidadFinal.getCargo_5() + Math.abs(cargo_5);
								cargo5Vcf = rentabilidadFinal.getCargo_11() + Math.abs(cargo_11);
							}
						}
						
						if ((rentabilidadFinal.getAbono_5() + abono_5) > 0) {
							tieneTraspasoObl = true;
						}
						
						if ((rentabilidadFinal.getAbono_11() + abono_11) > 0) {
							tieneTraspasoVcf = true;
						}
						
						if ((rentabilidadFinal.getAbono_17() + abono_17) > 0) {
							tieneTraspasoVsf = true;
						}
						
						acreditacionesFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + (abono_1 + abono_2 + abono_3) + abono5Obl + acreditacionesEtarcObl;
						cargosFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + (Math.abs(cargo_1) + Math.abs(cargo_3)) + Math.abs(cargo5Obl) + cargosEtarcObl;
						acreditacionesFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + (abono_7 + abono_8) + abono5Vcf + acreditacionesEtarcVcf;
						cargosFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + (Math.abs(cargo_7) + Math.abs(cargo_9)) + Math.abs(cargo5Vcf) + cargosEtarcVcf;
						acreditacionesFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + (abono_13 + abono_14 + abono_15) + abono5Vsf + acreditacionesEtarcVsf;
						cargosFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + (Math.abs(cargo_13) + Math.abs(cargo_15)) + Math.abs(cargo5Vsf) + cargosEtarcVsf;

						acreditacionesPeriodoFinalObl = rentabilidadFinal.getAbono_1() + rentabilidadFinal.getAbono_2() + rentabilidadFinal.getAbono_3() + (abono_1 + abono_2 + abono_3);
						cargosPeriodoFinalObl = Math.abs(rentabilidadFinal.getCargo_1()) + Math.abs(rentabilidadFinal.getCargo_3()) + (Math.abs(cargo_1) + Math.abs(cargo_3));
						acreditacionesPeriodoFinalVcf = rentabilidadFinal.getAbono_7() + rentabilidadFinal.getAbono_8() + (abono_7 + abono_8);
						cargosPeriodoFinalVcf = Math.abs(rentabilidadFinal.getCargo_7()) + Math.abs(rentabilidadFinal.getCargo_9()) + (Math.abs(cargo_7) + Math.abs(cargo_9));
						acreditacionesPeriodoFinalVsf = rentabilidadFinal.getAbono_13() + rentabilidadFinal.getAbono_14() + rentabilidadFinal.getAbono_15() + (abono_13 + abono_14 + abono_15);
						cargosPeriodoFinalVsf = Math.abs(rentabilidadFinal.getCargo_13()) + Math.abs(rentabilidadFinal.getCargo_15()) + (Math.abs(cargo_13) + Math.abs(cargo_15));

						saldoAfectoObl = rentabilidadFinal.getSaldoAfecto_OBL();
						saldoAfectoVcf = rentabilidadFinal.getSaldoAfecto_VCF();
						saldoAfectoVsf = rentabilidadFinal.getSaldoAfecto_VSF();
						saldoInafectoObl = rentabilidadFinal.getSaldoInafecto_OBL();
						saldoInafectoVcf = rentabilidadFinal.getSaldoInafecto_VCF();
						saldoInafectoVsf = rentabilidadFinal.getSaldoInafecto_VSF();

						saldoFinalObl = (cuotasObl) * valorCuotaFinalObl;
						saldoFinalVcf = (cuotasVcf) * valorCuotaFinalVcf;
						saldoFinalVsf = (cuotasVsf) * valorCuotaFinalVsf;

	 					saldoCicObl = saldoFinalObl;
						saldoCicVcf = saldoFinalVcf;
						saldoCicVsf = saldoFinalVsf;
						
						rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
						rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
						rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;

						rentabilidadObl = saldoFinalObl - ((acreditacionesFinalObl) - (cargosFinalObl));
						rentabilidadVcf = saldoFinalVcf - ((acreditacionesFinalVcf) - (cargosFinalVcf));
						rentabilidadVsf = saldoFinalVsf - ((acreditacionesFinalVsf) - (cargosFinalVsf));
						
						//Determinar si tiene periodo inicial
						// 1. Determinar si tiene periodo inicial (si tiene periodo inicial deberà de traer 5 registros)
						rentabilidadPeriodoFinalObl = saldoFinalObl - acreditacionesPeriodoFinalObl + cargosPeriodoFinalObl;
						rentabilidadPeriodoFinalVcf = saldoFinalVcf - acreditacionesPeriodoFinalVcf + cargosPeriodoFinalVcf;
						rentabilidadPeriodoFinalVsf = saldoFinalVsf - acreditacionesPeriodoFinalVsf + cargosPeriodoFinalVsf;
						
						rentabilidadPeriodoInicialObl = rentabilidadFinal.getAbono_5() + abono_5;
						rentabilidadPeriodoInicialVcf = rentabilidadFinal.getAbono_11() + abono_11;
						rentabilidadPeriodoInicialVsf = rentabilidadFinal.getAbono_17() + abono_17;
						
						rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
						rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
						rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;
						
						// OTXXXXX - Comisiones INI
						comiSaldoAbonoFinalOBL = new BigDecimal(comiSaldoAbonoOBL + Math.abs(rentabilidadFinal.getComiSaldoAbonoOBL().doubleValue()));
						comiMixRiaAbonoFinalOBL = new BigDecimal(comiMixRiaAbonoOBL + rentabilidadFinal.getComiMixRiaAbonoOBL().doubleValue());
						comiFluRiaAbonoFinalOBL = new BigDecimal(comiFluRiaAbonoOBL + rentabilidadFinal.getComiFluRiaAbonoOBL().doubleValue());
						comiMixRiaCargoFinalOBL = new BigDecimal(comiMixRiaCargoOBL + rentabilidadFinal.getComiMixRiaCargoOBL().doubleValue());
						comiFluRiaCargoFinalOBL = new BigDecimal(comiFluRiaCargoOBL + rentabilidadFinal.getComiFluRiaCargoOBL().doubleValue());
						seguNominAbonoFinalOBL = new BigDecimal(seguNominAbonoOBL + rentabilidadFinal.getSeguNominAbonoOBL().doubleValue());
						seguIntereAbonoFinalOBL = new BigDecimal(seguIntereAbonoOBL + rentabilidadFinal.getSeguIntereAbonoOBL().doubleValue());
						seguNominCargoFinalOBL = new BigDecimal(seguNominCargoOBL + rentabilidadFinal.getSeguNominCargoOBL().doubleValue());
						seguIntereCargoFinalOBL = new BigDecimal(seguIntereCargoOBL + rentabilidadFinal.getSeguIntereCargoOBL().doubleValue());
						comiSaldoAbonoFinalVCF = new BigDecimal(comiSaldoAbonoVCF + Math.abs(rentabilidadFinal.getComiSaldoAbonoVCF().doubleValue()));
						comiSaldoAbonoFinalVSF = new BigDecimal(comiSaldoAbonoVSF + Math.abs(rentabilidadFinal.getComiSaldoAbonoVSF().doubleValue()));
						
						inteMixRiaAbonoFinalOBL = new BigDecimal(inteMixRiaAbonoOBL + rentabilidadFinal.getInteMixRiaAbonoOBL().doubleValue());
						inteFluRiaAbonoFinalOBL = new BigDecimal(inteFluRiaAbonoOBL + rentabilidadFinal.getInteFluRiaAbonoOBL().doubleValue());
						inteMixRiaCargoFinalOBL = new BigDecimal(inteMixRiaCargoOBL + rentabilidadFinal.getInteMixRiaCargoOBL().doubleValue());
						inteFluRiaCargoFinalOBL = new BigDecimal(inteFluRiaCargoOBL + rentabilidadFinal.getInteFluRiaCargoOBL().doubleValue());
						// OTXXXXX - Comisiones FIN
						//----------------------------------------------------------------------------------------------------------------
						//----------------------------------------------------------------------------------------------------------------
					} else {
						tipoFondoObl = "";
						tipoFondoVcf = "";
						tipoFondoVsf = "";
						saldoAfectoObl = 0;
						saldoAfectoVcf = 0;
						saldoAfectoVsf = 0;
						saldoInafectoObl = 0;
						saldoInafectoVcf = 0;
						saldoInafectoVsf = 0;
						tieneObl = false;
						tieneVcf = false;
						tieneVsf = false;
						tieneRena04 = false;
	
						//----------------------------------------------------------------------------------------------------------------
						//----------------------------------------------------------------------------------------------------------------

						tipoFondoObl = devolverTipoFondo("", lstFondoMovimientoObl); //rentabilidadFinal.getFondo_OBL();
						tipoFondoVcf = devolverTipoFondo("", lstFondoMovimientoVcf); //rentabilidadFinal.getFondo_VCF();
						tipoFondoVsf = devolverTipoFondo("", lstFondoMovimientoVsf); //rentabilidadFinal.getFondo_VSF();
						
						if (lstValoresCuotaFinal != null && lstValoresCuotaFinal.size() > 1) {
							for (int i = 0; i< lstValoresCuotaFinal.size(); i++) {
								Ifdar7 valorCuota = lstValoresCuotaFinal.get(i);
								if (valorCuota.getFondo().trim().equals(tipoFondoObl)) {
									valorCuotaFinalObl = valorCuota.getValorCuota();
								} 
								
								if (valorCuota.getFondo().trim().equals(tipoFondoVcf)) {
									valorCuotaFinalVcf = valorCuota.getValorCuota();
								} 
									
								if (valorCuota.getFondo().trim().equals(tipoFondoVsf)) {
									valorCuotaFinalVsf = valorCuota.getValorCuota();
								}
							}
						}

						if (!tieneEtrarc) {
							abono5Obl = abono_5;
							abono5Vcf = abono_11;
							cargo5Obl = Math.abs(cargo_5);
							cargo5Vcf = Math.abs(cargo_11);
						} else {
							if (!etrarc.getFlagCargaRenta().equals("1")) {
								abono5Obl = abono_5;
								abono5Vcf = abono_11;
								cargo5Obl = Math.abs(cargo_5);
								cargo5Vcf = Math.abs(cargo_11);
							}
						}
						
						if ((abono_5) > 0) {
							tieneTraspasoObl = true;
						}
						
						if ((abono_11) > 0) {
							tieneTraspasoVcf = true;
						}
						
						if ((abono_17) > 0) {
							tieneTraspasoVsf = true;
						}
						
						acreditacionesFinalObl = (abono_1 + abono_2 + abono_3) + abono5Obl + acreditacionesEtarcObl;
						cargosFinalObl = (Math.abs(cargo_1) + Math.abs(cargo_3)) + Math.abs(cargo5Obl) + cargosEtarcObl;
						acreditacionesFinalVcf = (abono_7 + abono_8) + abono5Vcf + acreditacionesEtarcVcf;
						cargosFinalVcf = (Math.abs(cargo_7) + Math.abs(cargo_9)) + Math.abs(cargo5Vcf) + cargosEtarcVcf;
						acreditacionesFinalVsf = (abono_13 + abono_14 + abono_15) + abono5Vsf + acreditacionesEtarcVsf;
						cargosFinalVsf = (Math.abs(cargo_13) + Math.abs(cargo_15)) + Math.abs(cargo5Vsf) + cargosEtarcVsf;

						acreditacionesPeriodoFinalObl = (abono_1 + abono_2 + abono_3);
						cargosPeriodoFinalObl = (Math.abs(cargo_1) + Math.abs(cargo_3));
						acreditacionesPeriodoFinalVcf = (abono_7 + abono_8);
						cargosPeriodoFinalVcf = (Math.abs(cargo_7) + Math.abs(cargo_9));
						acreditacionesPeriodoFinalVsf = (abono_13 + abono_14 + abono_15);
						cargosPeriodoFinalVsf = (Math.abs(cargo_13) + Math.abs(cargo_15));

						saldoAfectoObl = 0;
						saldoAfectoVcf = 0;
						saldoAfectoVsf = 0;
						saldoInafectoObl = 0;
						saldoInafectoVcf = 0;
						saldoInafectoVsf = 0;

						saldoFinalObl = (cuotasObl) * valorCuotaFinalObl;
						saldoFinalVcf = (cuotasVcf) * valorCuotaFinalVcf;
						saldoFinalVsf = (cuotasVsf) * valorCuotaFinalVsf;

	 					saldoCicObl = saldoFinalObl;
						saldoCicVcf = saldoFinalVcf;
						saldoCicVsf = saldoFinalVsf;
						
						rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
						rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
						rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;

						rentabilidadObl = saldoFinalObl - ((acreditacionesFinalObl) - (cargosFinalObl));
						rentabilidadVcf = saldoFinalVcf - ((acreditacionesFinalVcf) - (cargosFinalVcf));
						rentabilidadVsf = saldoFinalVsf - ((acreditacionesFinalVsf) - (cargosFinalVsf));
						
						//Determinar si tiene periodo inicial
						// 1. Determinar si tiene periodo inicial (si tiene periodo inicial deberà de traer 5 registros)
						rentabilidadPeriodoFinalObl = saldoFinalObl - acreditacionesPeriodoFinalObl + cargosPeriodoFinalObl;
						rentabilidadPeriodoFinalVcf = saldoFinalVcf - acreditacionesPeriodoFinalVcf + cargosPeriodoFinalVcf;
						rentabilidadPeriodoFinalVsf = saldoFinalVsf - acreditacionesPeriodoFinalVsf + cargosPeriodoFinalVsf;
						
						rentabilidadPeriodoInicialObl = abono_5;
						rentabilidadPeriodoInicialVcf = abono_11;
						rentabilidadPeriodoInicialVsf = abono_17;
						
						rentabilidadPeriodoTotalObl = rentabilidadPeriodoFinalObl - rentabilidadPeriodoInicialObl;
						rentabilidadPeriodoTotalVcf = rentabilidadPeriodoFinalVcf - rentabilidadPeriodoInicialVcf;
						rentabilidadPeriodoTotalVsf = rentabilidadPeriodoFinalVsf - rentabilidadPeriodoInicialVsf;
						
						// OTXXXXX - Comisiones INI
						comiSaldoAbonoFinalOBL = new BigDecimal(Math.abs(comiSaldoAbonoOBL));
						comiMixRiaAbonoFinalOBL = new BigDecimal(comiMixRiaAbonoOBL);
						comiFluRiaAbonoFinalOBL = new BigDecimal(comiFluRiaAbonoOBL);
						comiMixRiaCargoFinalOBL = new BigDecimal(comiMixRiaCargoOBL);
						comiFluRiaCargoFinalOBL = new BigDecimal(comiFluRiaCargoOBL);
						seguNominAbonoFinalOBL = new BigDecimal(seguNominAbonoOBL);
						seguIntereAbonoFinalOBL = new BigDecimal(seguIntereAbonoOBL);
						seguNominCargoFinalOBL = new BigDecimal(seguNominCargoOBL);
						seguIntereCargoFinalOBL = new BigDecimal(seguIntereCargoOBL);
						comiSaldoAbonoFinalVCF = new BigDecimal(Math.abs(comiSaldoAbonoVCF));
						comiSaldoAbonoFinalVSF = new BigDecimal(Math.abs(comiSaldoAbonoVSF));
	
						inteMixRiaAbonoFinalOBL = new BigDecimal(inteMixRiaAbonoOBL);
						inteFluRiaAbonoFinalOBL = new BigDecimal(inteFluRiaAbonoOBL);
						inteMixRiaCargoFinalOBL = new BigDecimal(inteMixRiaCargoOBL);
						inteFluRiaCargoFinalOBL = new BigDecimal(inteFluRiaCargoOBL);
						// OTXXXXX - Comisiones FIN
						//----------------------------------------------------------------------------------------------------------------
						//----------------------------------------------------------------------------------------------------------------
					}
				}
			}
			
			
			//*****************************************************************************************************************************************************
			//*****************************************************************************************************************************************************
			
			//*****************************************************************************************************************************************************
			//* CALCULAR EL FLAG DE ERROR POR CADA PRODUCTO
			//*****************************************************************************************************************************************************
			/* Flags:
			 *   0 = Ok
			 *   1 = Error CIC
			 *   2 = Movimientos sin mapeo
			 *   3 = Error cantidad de movimientos
			 *   4 = Error de CIC y movimientos sin mapeo (1 y 2)
			 */
			
			String flagErrorFinalObl = Constantes.OK;
			String flagErrorFinalVcf = Constantes.OK;
			String flagErrorFinalVsf = Constantes.OK;
			
			boolean tieneErrorListaCuspp = true;
			
			if (lstCuspp != null && lstCuspp.size() > 0) {
				ListaCuspp lista = lstCuspp.get(0);
				if (lista.getFlag().equals("1")) {
					tieneErrorListaCuspp = false;
				}
			}
				
			flagErrorFinalObl = calcularFlagObl(tieneErrorRenaObl, tieneErrorListaCuspp, tieneEtrarc, tieneRena04, tieneTraspasoObl, etrarc);
			flagErrorFinalVcf = calcularFlagVcf(tieneErrorRenaVcf, tieneErrorListaCuspp, tieneEtrarc, tieneRena04, tieneTraspasoVcf, etrarc);
			flagErrorFinalVsf = calcularFlagVsf(tieneErrorRenaVsf, tieneErrorListaCuspp, tieneEtrarc, tieneRena04, tieneTraspasoVsf);
			
			BigDecimal rentabilidadTotalObl = new BigDecimal(rentabilidadObl);
			BigDecimal rentabilidadTotalVcf = new BigDecimal(rentabilidadVcf);
			BigDecimal rentabilidadTotalVsf = new BigDecimal(rentabilidadVsf);
			BigDecimal rentabilidadPeriodoObl = new BigDecimal(rentabilidadPeriodoTotalObl);
			BigDecimal rentabilidadPeriodoVcf = new BigDecimal(rentabilidadPeriodoTotalVcf);
			BigDecimal rentabilidadPeriodoVsf = new BigDecimal(rentabilidadPeriodoTotalVsf);
			BigDecimal saldoObl = new BigDecimal(saldoCicObl);
			BigDecimal saldoVcf = new BigDecimal(saldoCicVcf);
			BigDecimal saldoVsf = new BigDecimal(saldoCicVsf);
			BigDecimal acreditacionesObl = new BigDecimal(acreditacionesFinalObl);
			BigDecimal acreditacionesVcf = new BigDecimal(acreditacionesFinalVcf);
			BigDecimal acreditacionesVsf = new BigDecimal(acreditacionesFinalVsf);
			BigDecimal cargosObl = new BigDecimal(cargosFinalObl);
			BigDecimal cargosVcf = new BigDecimal(cargosFinalVcf);
			BigDecimal cargosVsf = new BigDecimal(cargosFinalVsf);
			rentabilidadPeriodoObl = rentabilidadPeriodoObl.setScale(2, RoundingMode.HALF_UP);
			rentabilidadPeriodoVcf = rentabilidadPeriodoVcf.setScale(2, RoundingMode.HALF_UP);
			rentabilidadPeriodoVsf = rentabilidadPeriodoVsf.setScale(2, RoundingMode.HALF_UP);
			rentabilidadTotalObl = rentabilidadTotalObl.setScale(2, RoundingMode.HALF_UP);
			rentabilidadTotalVcf = rentabilidadTotalVcf.setScale(2, RoundingMode.HALF_UP);
			rentabilidadTotalVsf = rentabilidadTotalVsf.setScale(2, RoundingMode.HALF_UP);
			saldoObl = saldoObl.setScale(2, RoundingMode.HALF_UP);
			saldoVcf = saldoVcf.setScale(2, RoundingMode.HALF_UP);
			saldoVsf = saldoVsf.setScale(2, RoundingMode.HALF_UP);
			acreditacionesObl = acreditacionesObl.setScale(2, RoundingMode.HALF_UP);
			acreditacionesVcf = acreditacionesVcf.setScale(2, RoundingMode.HALF_UP);
			acreditacionesVsf = acreditacionesVsf.setScale(2, RoundingMode.HALF_UP);
			cargosObl = cargosObl.setScale(2, RoundingMode.HALF_UP);
			cargosVcf = cargosVcf.setScale(2, RoundingMode.HALF_UP);
			cargosVsf = cargosVsf.setScale(2, RoundingMode.HALF_UP);			
			
			// OTXXXXX - Comisiones INI
			comiSaldoAbonoFinalOBL = comiSaldoAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			comiMixRiaAbonoFinalOBL = comiMixRiaAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			comiFluRiaAbonoFinalOBL = comiFluRiaAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			comiMixRiaCargoFinalOBL = comiMixRiaCargoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			comiFluRiaCargoFinalOBL = comiFluRiaCargoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			seguNominAbonoFinalOBL = seguNominAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			seguIntereAbonoFinalOBL = seguIntereAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			seguNominCargoFinalOBL = seguNominCargoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			seguIntereCargoFinalOBL = seguIntereCargoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			comiSaldoAbonoFinalVCF = comiSaldoAbonoFinalVCF.setScale(2, RoundingMode.HALF_UP);
			comiSaldoAbonoFinalVSF = comiSaldoAbonoFinalVSF.setScale(2, RoundingMode.HALF_UP);
			
			inteMixRiaAbonoFinalOBL = inteMixRiaAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			inteFluRiaAbonoFinalOBL = inteFluRiaAbonoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			inteMixRiaCargoFinalOBL = inteMixRiaCargoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			inteFluRiaCargoFinalOBL = inteFluRiaCargoFinalOBL.setScale(2, RoundingMode.HALF_UP);
			// OTXXXXX - Comisiones FIN
			
			tieneObl = true;
			tieneVcf = true;
			tieneVsf = true;
			if (tipoFondoObl.equals("X") || tipoFondoObl.equals("") || tipoFondoObl.equals("0")) {
				tieneObl = false;
			}
			if (tipoFondoVcf.equals("X") || tipoFondoVcf.equals("") || tipoFondoVcf.equals("0")) {
				tieneVcf = false;
			}
			if (tipoFondoVsf.equals("X") || tipoFondoVsf.equals("") || tipoFondoVsf.equals("0")) {
				tieneVsf = false;
			}
			
			Comision comisionAbonoObl = new Comision();
			Comision comisionCargoObl = new Comision();
			Comision comisionAbonoVcf = new Comision();
			Comision comisionAbonoVsf = new Comision();
			//Comision comisionCargoVcf = new Comision();
			
			comisionAbonoObl.setComisionSaldo(comiSaldoAbonoFinalOBL);
			comisionAbonoObl.setComisionMixtaRIA(comiMixRiaAbonoFinalOBL);
			comisionAbonoObl.setComisionFlujoRIA(comiFluRiaAbonoFinalOBL);
			comisionAbonoObl.setSeguroNominal(seguNominAbonoFinalOBL);
			comisionAbonoObl.setSeguroInteres(seguIntereAbonoFinalOBL);
			comisionAbonoObl.setInteresMixtaRIA(inteMixRiaAbonoFinalOBL);
			comisionAbonoObl.setInteresFlujoRIA(inteFluRiaAbonoFinalOBL);
			
			comisionCargoObl.setComisionMixtaRIA(comiMixRiaCargoFinalOBL);
			comisionCargoObl.setComisionFlujoRIA(comiFluRiaCargoFinalOBL);
			comisionCargoObl.setSeguroNominal(seguNominCargoFinalOBL);
			comisionCargoObl.setSeguroInteres(seguIntereCargoFinalOBL);
			comisionCargoObl.setInteresMixtaRIA(inteMixRiaCargoFinalOBL);
			comisionCargoObl.setInteresFlujoRIA(inteFluRiaCargoFinalOBL);
			
			comisionAbonoVcf.setComisionSaldo(comiSaldoAbonoFinalVCF);
			comisionAbonoVsf.setComisionSaldo(comiSaldoAbonoFinalVSF);
			
			ComisionMovimiento comisionMovimientoObl = new ComisionMovimiento();
			ComisionMovimiento comisionMovimientoVcf = new ComisionMovimiento();
			ComisionMovimiento comisionMovimientoVsf = new ComisionMovimiento();
			
			comisionMovimientoObl.setAbono(comisionAbonoObl);
			comisionMovimientoObl.setCargo(comisionCargoObl);
			
			comisionMovimientoVcf.setAbono(comisionAbonoVcf);
			comisionMovimientoVsf.setAbono(comisionAbonoVsf);
			//comisionMovimientoVcf.setCargo(comisionCargoVcf);
			
			// Cargar la información de los productos
			productoObl = obtenerProducto(tieneObl, flagErrorFinalObl, tipoFondoObl, rentabilidadTotalObl.doubleValue(), rentabilidadPeriodoObl.doubleValue(),
					saldoObl.doubleValue(), cuotasObl, saldoAfectoObl, saldoInafectoObl, acreditacionesObl.doubleValue(),
					cargosObl.doubleValue(), abono_3, flagErrorFinalObl, lstMovimientosOblJSON, lstComisionFlujoOblJSON, lstComisionSaldoOblJSON,
					comisionMovimientoObl);
			
			productoVcf = obtenerProducto(tieneVcf, flagErrorFinalVcf, tipoFondoVcf, rentabilidadTotalVcf.doubleValue(), rentabilidadPeriodoVcf.doubleValue(),
					saldoVcf.doubleValue(), cuotasVcf, saldoAfectoVcf, saldoInafectoVcf, acreditacionesVcf.doubleValue(),
					cargosVcf.doubleValue(), 0, flagErrorFinalVcf, lstMovimientosVcfJSON, lstComisionFlujoVcfJSON, lstComisionSaldoVcfJSON,
					comisionMovimientoVcf);
			
			productoVsf= obtenerProducto(tieneVsf, flagErrorFinalVsf, tipoFondoVsf, rentabilidadTotalVsf.doubleValue(), rentabilidadPeriodoVsf.doubleValue(),
					saldoVsf.doubleValue(), cuotasVsf, saldoAfectoVsf, saldoInafectoVsf, acreditacionesVsf.doubleValue(),
					cargosVsf.doubleValue(), 0, flagErrorFinalVsf, lstMovimientosVsfJSON, lstComisionFlujoVsfJSON, lstComisionSaldoVsfJSON,
					comisionMovimientoVsf);

			rentabilidadEECC = new RentabilidadEECC();
			rentabilidadEECC.setCuspp(cuspp);
			
			if (tieneObl) {
				rentabilidadEECC.setObl(productoObl);
			} else {
				rentabilidadEECC.setObl(new Producto());
			}
			
			if (tieneVcf) {
				rentabilidadEECC.setVcf(productoVcf);
			} else {
				rentabilidadEECC.setVcf(new Producto());
			}
			
			if (tieneVsf) {
				rentabilidadEECC.setVsf(productoVsf);
			} else {
				rentabilidadEECC.setVsf(new Producto());
			}
			
			LOGGER.traceExit();
			
			if (rentabilidadEECC != null) {
				String jsonString = new Gson().toJson(rentabilidadEECC);
				return jsonString;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e); 
			return "Message: " + e.getMessage() + "  -  Cause:" + e.getCause();
		}

		return null;
	}

	private List<Rentabilidad> ejecutarProcedimientoAlmacenadoRentabilidad(String cuspp, String fechaInicio, String fechaFin, String flag) {
		StoredProcedureQuery spqRentabilidad = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_RENTABILIDAD, Rentabilidad.class);
		List<Rentabilidad> lstRentabilidad = new ArrayList<>();

		try {
			spqRentabilidad.registerStoredProcedureParameter("P_CUSPP", String.class, ParameterMode.IN);
			spqRentabilidad.registerStoredProcedureParameter("P_FECHA_INICIO", String.class, ParameterMode.IN);
			spqRentabilidad.registerStoredProcedureParameter("P_FECHA_FIN", String.class, ParameterMode.IN);
			spqRentabilidad.registerStoredProcedureParameter("P_FLAG", String.class, ParameterMode.IN);
			spqRentabilidad.setParameter("P_CUSPP", cuspp);
			spqRentabilidad.setParameter("P_FECHA_INICIO", fechaInicio);
			spqRentabilidad.setParameter("P_FECHA_FIN", fechaFin);
			spqRentabilidad.setParameter("P_FLAG", flag);
			spqRentabilidad.execute();

			List<Rentabilidad> resultRentabilidad = (List<Rentabilidad>) spqRentabilidad.getResultList();
			
			lstRentabilidad = resultRentabilidad;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e); 
			throw e;
		}

		return lstRentabilidad;
	}
	
	private List<Cuear5> ejecutarProcedimientoAlmacenadoCuear5(String cuspp) {
		StoredProcedureQuery spqCuear5 = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_CUEAR5, Cuear5.class);
		List<Cuear5> lstCuear5 = new ArrayList<>();
		
		try {
			spqCuear5.registerStoredProcedureParameter("P_CUSPP", String.class, ParameterMode.IN);
			spqCuear5.setParameter("P_CUSPP", cuspp);
			spqCuear5.execute();
			
			List<Cuear5> resultCuear5 = (List<Cuear5>) spqCuear5.getResultList();
			
			lstCuear5 = resultCuear5;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			throw e;
		}
		
		return lstCuear5;
	}
	
	private List<Movimientos> ejecutarProcedimientoAlmacenadoMovimientos(String cuspp, String fechaInicio, String fechaFin, String flag) {
		StoredProcedureQuery spqMovimientos = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_MOVIMIENTOS, Movimientos.class);
		List<Movimientos> lstMovimientos = new ArrayList<>();
		
		try {
			spqMovimientos.registerStoredProcedureParameter("P_CUSPP", String.class, ParameterMode.IN);
			spqMovimientos.registerStoredProcedureParameter("P_FECHA_INICIO", String.class, ParameterMode.IN);
			spqMovimientos.registerStoredProcedureParameter("P_FECHA_FIN", String.class, ParameterMode.IN);
			spqMovimientos.registerStoredProcedureParameter("P_FLAG", String.class, ParameterMode.IN);
			spqMovimientos.setParameter("P_CUSPP", cuspp);
			spqMovimientos.setParameter("P_FECHA_INICIO", fechaInicio);
			spqMovimientos.setParameter("P_FECHA_FIN", fechaFin);
			spqMovimientos.setParameter("P_FLAG", flag);
			spqMovimientos.execute();
			
			List<Movimientos> resultMovimientos = (List<Movimientos>) spqMovimientos.getResultList();
			
			lstMovimientos = resultMovimientos;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			throw e;
		}
		
		return lstMovimientos;
	}
	
	private List<ListaCuspp> ejecutarProcedimientoAlmacenadoListaCuspp(String cuspp) {
		StoredProcedureQuery spqListaCuspp = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_LISTA_CUSPP, ListaCuspp.class);
		List<ListaCuspp> lstCuspp = new ArrayList<>();
		
		try {
			spqListaCuspp.registerStoredProcedureParameter("P_CUSPP", String.class, ParameterMode.IN);
			spqListaCuspp.setParameter("P_CUSPP", cuspp);
			spqListaCuspp.execute();
			
			List<ListaCuspp> resultListaCuspp = (List<ListaCuspp>) spqListaCuspp.getResultList();
			
			lstCuspp = resultListaCuspp;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			throw e;
		}
		
		return lstCuspp;
	}
	
	private List<Etrarc> ejecutarProcedimientoAlmacenadoEtaarc(String cuspp) {
		StoredProcedureQuery spqEtrarc = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_ETRARC, Etrarc.class);
		List<Etrarc> lstEtrarc = new ArrayList<>();
		
		try {
			spqEtrarc.registerStoredProcedureParameter("P_CUSPP", String.class, ParameterMode.IN);
			spqEtrarc.setParameter("P_CUSPP", cuspp);
			spqEtrarc.execute();
			
			List<Etrarc> resultEtrarc = (List<Etrarc>) spqEtrarc.getResultList();
			
			lstEtrarc = resultEtrarc;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			throw e;
		}
		
		return lstEtrarc;
	}
	
	private List<ComisionFlujo> ejecutarProcedimientoAlmacenadoComisiones(String cuspp, String fechaInicio, String fechaFin, String flag) {
		StoredProcedureQuery spqComision = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_COMISIONES, ComisionFlujo.class);
		List<ComisionFlujo> lstComisionFlujo = new ArrayList<>();
		
		try {
			spqComision.registerStoredProcedureParameter("P_CUSPP", String.class, ParameterMode.IN);
			spqComision.registerStoredProcedureParameter("P_FECHA_INICIO", String.class, ParameterMode.IN);
			spqComision.registerStoredProcedureParameter("P_FECHA_FIN", String.class, ParameterMode.IN);
			spqComision.registerStoredProcedureParameter("P_FLAG", String.class, ParameterMode.IN);
			spqComision.setParameter("P_CUSPP", cuspp);
			spqComision.setParameter("P_FECHA_INICIO", fechaInicio);
			spqComision.setParameter("P_FECHA_FIN", fechaFin);
			spqComision.setParameter("P_FLAG", flag);
			spqComision.execute();
			
			List<ComisionFlujo> resultComisiones = (List<ComisionFlujo>) spqComision.getResultList();
			
			lstComisionFlujo = resultComisiones;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			throw e;
		}
		
		return lstComisionFlujo;
	}
	
	private List<Ifdar7> ejecutarProcedimientoAlmacenadoValorCuota(String fechaInicio, String fechaFin, String flag) {
		StoredProcedureQuery spqValorCuota = emRentabilidad.createStoredProcedureQuery(Procedimientos.OBTENER_VALOR_CUOTA, Ifdar7.class);
		List<Ifdar7> lstValoresCuota = new ArrayList<>();
		
		try {
			spqValorCuota.registerStoredProcedureParameter("P_FECHA_INICIO", String.class, ParameterMode.IN);
			spqValorCuota.registerStoredProcedureParameter("P_FECHA_FIN", String.class, ParameterMode.IN);
			spqValorCuota.registerStoredProcedureParameter("P_FLAG", String.class, ParameterMode.IN);
			spqValorCuota.setParameter("P_FECHA_INICIO", fechaInicio);
			spqValorCuota.setParameter("P_FECHA_FIN", fechaFin);
			spqValorCuota.setParameter("P_FLAG", flag);
			spqValorCuota.execute();
			
			List<Ifdar7> resultValoresCuotas = (List<Ifdar7>)spqValorCuota.getResultList();
			
			lstValoresCuota = resultValoresCuotas;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			throw e;
		}
		
		return lstValoresCuota;
	}
	
	private String devolverTipoFondo(String tipoFondo, List<String> lstFondos) {
		String fondoFinal = tipoFondo;

		if (lstFondos != null && lstFondos.size() > 0) {
			String fondo = lstFondos.get(lstFondos.size() - 1);
			if (!(fondo.equals("") || fondo.equals("0") || fondo.toUpperCase().equals("X"))) {
				fondoFinal = fondo;
			}
		}
		
		return fondoFinal;
	}
	
	private String calcularFlagObl(boolean tieneErrorRenaObl, boolean tieneErrorListaCuspp, boolean tieneEtrarc, boolean tieneRena04, boolean tieneTraspasoObl, Etrarc etrarc) {
		String flagErrorFinalObl = Constantes.OK;
		boolean puroObl = false;
		
		// Analizar error para el producto OBL
		if (tieneErrorRenaObl) {
			flagErrorFinalObl = Constantes.ERROR_GENERAL;
		} else {
			if (!tieneErrorListaCuspp) {
				flagErrorFinalObl = Constantes.RI;
			} else {
				if (!tieneEtrarc) {
					flagErrorFinalObl = Constantes.OK;
				} else {
					if (!etrarc.getFlagCargaRenta().equals("1")) {
						flagErrorFinalObl = Constantes.RI;
					}
				}
			}
		}
		
		if (!tieneEtrarc && tieneRena04 && !tieneTraspasoObl) {
			puroObl = true;
		}
		
		if (flagErrorFinalObl.equals(Constantes.OK) && puroObl) {
			flagErrorFinalObl = Constantes.IP;
		} else if (flagErrorFinalObl.equals(Constantes.OK) && !puroObl) {
			flagErrorFinalObl = Constantes.OK;
		} else if(flagErrorFinalObl.equals(Constantes.RI) && puroObl) {
			flagErrorFinalObl = Constantes.IP;
		} else if(flagErrorFinalObl.equals(Constantes.RI) && !puroObl) {
			flagErrorFinalObl = Constantes.RI;
		} else if(flagErrorFinalObl.equals(Constantes.ERROR_GENERAL)) {
			flagErrorFinalObl = Constantes.ERROR_GENERAL;
		}
		
		return flagErrorFinalObl;
	}
	
	private String calcularFlagVcf(boolean tieneErrorRenaVcf, boolean tieneErrorListaCuspp, boolean tieneEtrarc, boolean tieneRena04, boolean tieneTraspasoVcf, Etrarc etrarc) {
		String flagErrorFinalVcf = Constantes.OK;
		boolean puroVcf = false;
		
		// Analizar error para el producto VCF
		if (tieneErrorRenaVcf) {
			flagErrorFinalVcf = Constantes.ERROR_GENERAL;
		} else {
			if (!tieneErrorListaCuspp) {
				flagErrorFinalVcf = Constantes.RI;
			} else {
				if (!tieneEtrarc) {
					flagErrorFinalVcf = Constantes.OK;
				} else {
					if (!etrarc.getFlagCargaRenta().equals("1")) {
						flagErrorFinalVcf = Constantes.RI;
					}
				}
			}
		}
					
		if (!tieneEtrarc && tieneRena04 && !tieneTraspasoVcf) {
			puroVcf = true;
		}
		
		if (flagErrorFinalVcf.equals(Constantes.OK) && puroVcf) {
			flagErrorFinalVcf = Constantes.IP;
		} else if (flagErrorFinalVcf.equals(Constantes.OK) && !puroVcf) {
			flagErrorFinalVcf = Constantes.OK;
		} else if(flagErrorFinalVcf.equals(Constantes.RI) && puroVcf) {
			flagErrorFinalVcf = Constantes.IP;
		} else if(flagErrorFinalVcf.equals(Constantes.RI) && !puroVcf) {
			flagErrorFinalVcf = Constantes.RI;
		} else if(flagErrorFinalVcf.equals(Constantes.ERROR_GENERAL)) {
			flagErrorFinalVcf = Constantes.ERROR_GENERAL;
		}
		
		return flagErrorFinalVcf;
	}
	
	private String calcularFlagVsf(boolean tieneErrorRenaVsf, boolean tieneErrorListaCuspp, boolean tieneEtrarc, boolean tieneRena04, boolean tieneTraspasoVsf) {
		String flagErrorFinalVsf = Constantes.OK;
		boolean puroVsf = false;
		
		// Analizar error para el producto VSF
		if (tieneErrorRenaVsf) {
			flagErrorFinalVsf = Constantes.ERROR_GENERAL;
		} else {
			flagErrorFinalVsf = Constantes.OK;
		}
		
		if (tieneRena04 && !tieneTraspasoVsf) {
			puroVsf = true;
		}
		
		if (flagErrorFinalVsf.equals(Constantes.OK) && puroVsf) {
			flagErrorFinalVsf = Constantes.IP;
		} else if (flagErrorFinalVsf.equals(Constantes.OK) && !puroVsf) {
			flagErrorFinalVsf = Constantes.OK;
		} else if(flagErrorFinalVsf.equals(Constantes.RI) && puroVsf) {
			flagErrorFinalVsf = Constantes.IP;
		} else if(flagErrorFinalVsf.equals(Constantes.RI) && !puroVsf) {
			flagErrorFinalVsf = Constantes.RI;
		} else if(flagErrorFinalVsf.equals(Constantes.ERROR_GENERAL)) {
			flagErrorFinalVsf = Constantes.ERROR_GENERAL;
		}
		
		return flagErrorFinalVsf;
	}
	
	private Producto obtenerProducto(boolean tieneProducto, String error, String tipoFondo, double rentabilidadTotal, double rentabilidadPeriodo,
			double saldo, double cuotas, double saldoAfecto, double saldoInafecto, double acreditaciones, double cargos, double abono_5, String flagErrorFinal, 
			List<MovimientosJSON> lstMovimientos, List<ComisionFlujoJSON> lstComisionFlujo, List<ComisionSaldoJSON> lstComisionSaldo,
			ComisionMovimiento comision) {
		Producto producto = new Producto();
		
		if (tieneProducto && error.equals(Constantes.ERROR_GENERAL)) {
			producto = new Producto();
			producto.setTipoFondo(tipoFondo);
			producto.setRentabilidad(0.0);
			producto.setRentabilidadPeriodo(0.0);
			producto.setSaldoCICActual(0.0);
			producto.setSaldoCICCuotas(0.0);
			producto.setSaldoAfecto(0.0);
			producto.setSaldoInafecto(0.0);
			producto.setTotalAcreditaciones(0.0);
			producto.setTotalCargos(0.0);
			producto.setInteresLegal(0.0);
			producto.setFlagError(flagErrorFinal);
			producto.setMovimientos(new ArrayList<>());
			producto.setComisionFlujo(new ArrayList<>());
			producto.setComisionSaldo(new ArrayList<>());
		} else {
			producto.setTipoFondo(tipoFondo);
			producto.setRentabilidad(rentabilidadTotal);
			producto.setRentabilidadPeriodo(rentabilidadPeriodo);
			producto.setSaldoCICActual(saldo);
			producto.setSaldoCICCuotas(cuotas);
			producto.setSaldoAfecto(saldoAfecto);
			producto.setSaldoInafecto(saldoInafecto);
			producto.setTotalAcreditaciones(acreditaciones);
			producto.setTotalCargos(cargos);
			producto.setInteresLegal(abono_5);
			producto.setFlagError(flagErrorFinal);
			producto.setMovimientos(lstMovimientos);
			producto.setComisionFlujo(lstComisionFlujo);
			producto.setComisionSaldo(lstComisionSaldo);
			producto.setComisiones(comision);
		}
		
		return producto;
	}
}
