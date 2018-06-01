package com.integra.rentabilidad.global;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Propiedades {
	private final static Logger LOGGER = LogManager.getLogger(Propiedades.class);
	private static final String rutaProperties = "aplicacion.properties";
	private static final String urlServicioDatos;

	public static String getUrlServicioDatos() {
		return urlServicioDatos;
	}

	static {
		Properties propiedades = new Properties();
		LOGGER.error("Propiedades.class");
		
		try {
			InputStream fileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(rutaProperties);
			propiedades.load(fileStream);
			fileStream.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("No se pudo modificar el tiempo");
			LOGGER.error(e);
			LOGGER.error("FileNotFoundException" + e.getMessage() + " "+ e.getCause() );
		} catch (IOException e) {
			LOGGER.error("Error al cargar el archivo");
			LOGGER.error(e);
			
		}catch (Exception e) {
			LOGGER.error(e);
			
		}
		
		urlServicioDatos = propiedades.getProperty("url-rentabilidad-datos");
	}

}
