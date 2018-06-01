package com.integra.rentabilidad.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ParametrosRentabilidad {
	
	@XmlElement
	public String cuspp;
	@XmlElement
	public String fechaInicio;
	@XmlElement
	public String fechaFin;
	@XmlElement
	public String flag;
	
	@Override
	public String toString() {
		return "ParametrosRentabilidad [cuspp=" + cuspp + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", flag=" + flag + "]";
	}

}
