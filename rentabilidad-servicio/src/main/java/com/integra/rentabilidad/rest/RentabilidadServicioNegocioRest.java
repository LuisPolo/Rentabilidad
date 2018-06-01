/**
 * 
 * Descripción: Interfaz que contiene los servicios de Extractor.
 * 
 * @author Rosmery Contreras
 * @since 11/09/2017
 * @version OT10776
 * 
 */

package com.integra.rentabilidad.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.integra.rentabilidad.modelo.ParametrosRentabilidad;
import com.integra.seguridad.servicio.cliente.Secured;

@Path(value = "rentabilidad")
public interface RentabilidadServicioNegocioRest{

	@POST
	//@Secured
	@Path(value = "/obtenerRentabilidadEECC")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	String obtenerRentabilidadEECC(ParametrosRentabilidad parametros);

}
