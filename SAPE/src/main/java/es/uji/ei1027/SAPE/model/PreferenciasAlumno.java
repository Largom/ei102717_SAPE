package es.uji.ei1027.SAPE.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreferenciasAlumno {

	private String idEstudiante;
	private List<Short> preferencias;
	private Date ultimoCambio;
	private boolean cerrada;
	
	/**
	 * Constructor por defecto de Preferencias de un Alumno
	 */
	public PreferenciasAlumno() {
		super();
	}

	/**
	 * Constructor de Preferencias de un Alumno
	 * @param idEstudiante
	 * @param ultimoCambio
	 * @param cerrada
	 * @param preferencias
	 * @throws IllegalArgumentException
	 */
	public PreferenciasAlumno(final String idEstudiante, final Date ultimoCambio, final boolean cerrada, final List<Short> preferencias) throws IllegalArgumentException {
		super();
		this.idEstudiante = idEstudiante;
		this.ultimoCambio = ultimoCambio;
		this.cerrada = cerrada;
		this.preferencias = preferencias;
	}

	/**
	 * @return las preferencias
	 */
	public final List<Short> getPreferencias() {
		return preferencias;
	}


	/**
	 * @return el idEstudiante
	 */
	public final String getIdEstudiante() {
		return idEstudiante;
	}

	/**
	 * @return el ultimoCambio
	 */
	public final Date getUltimoCambio() {
		return ultimoCambio;
	}

	/**
	 * @return se se encuentra cerrada
	 */
	public final boolean isCerrada() {
		return cerrada;
	}

	
	

}
