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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.net.ssl.HttpsURLConnection;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.integra.rentabilidad.global.Propiedades;
import com.integra.rentabilidad.modelo.ParametrosRentabilidad;
import com.integra.rentabilidad.rest.RentabilidadServicioNegocioRest;

@RequestScoped
public class RentabilidadNegocioServicio implements RentabilidadServicioNegocioRest {
	
	private final static Logger LOGGER = LogManager.getLogger(RentabilidadNegocioServicio.class);

	@Override
	public String obtenerRentabilidadEECC(ParametrosRentabilidad parametros) {
		LOGGER.info("Servicio Negocios: obtenerRentabilidadEECC");
		
		String parametrosJson = new Gson().toJson(parametros);
		
		String json = "";
		String urlServicioDatos = Propiedades.getUrlServicioDatos();
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(urlServicioDatos);
		String respuesta = target.request(MediaType.APPLICATION_JSON_TYPE)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
				.post(Entity.json(parametrosJson), String.class);

		json = respuesta;

		return json;
	}
}