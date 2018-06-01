/**
 * 
 * Descripcion: Clase abstracta que contiene las conexiones a bases de datos.
 *  
 * @author Rosmery Contreras
 * @since 11/09/2017
 * @version OT10776
 * 
 */
package com.integra.rentabilidad.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class DatosBase {

	@PersistenceContext(unitName = "Rentabilidad-UP", type = PersistenceContextType.TRANSACTION)
	protected EntityManager emRentabilidad;

}
