/**
 * 
 * Descripción: Clase que implementa los servicios para Extractor.
 * 
 * @author Rosmery Contreras
 * @since 11/09/2017
 * @version OT10776
 * 
 */
 
 package com.integra.rentabilidad.servicio;

import java.io.StringReader;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.integra.rentabilidad.datos.RentabilidadDatos;
import com.integra.rentabilidad.rest.RentabilidadServicioDatosRest;

@RequestScoped
public class RentabilidadServicioDatos implements RentabilidadServicioDatosRest {
	
	private final static Logger LOGGER = LogManager.getLogger(RentabilidadServicioDatos.class);
	@EJB
	private RentabilidadDatos datos;

	@Override
	public String obtenerRentabilidadEECC(String parametros) {
		LOGGER.info("Servicio Datos: obtenerRentabilidadEECC");
		
		String cuspp;
		String fechaInicio;
		String fechaFin;
		String flag;

		JsonObject parametrosJson = Json.createReader(new StringReader(parametros)).readObject();
		
		cuspp = parametrosJson.getString("cuspp");
		fechaInicio = parametrosJson.getString("fechaInicio");
		fechaFin = parametrosJson.getString("fechaFin");
		flag = parametrosJson.getString("flag");
		
		String json = "";
		json = datos.obtenerRentabilidad(cuspp, fechaInicio, fechaFin, flag);
		
		return json;
	}
	
}