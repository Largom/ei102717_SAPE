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
	 * @param preferencias como maximo 5
	 * @param ultimoCambio
	 * @param cerrada
	 * @throws IllegalArgumentException
	 */
	public PreferenciasAlumno(final String idEstudiante, final Date ultimoCambio, final boolean cerrada) throws IllegalArgumentException {
		super();
		this.idEstudiante = idEstudiante;
		this.ultimoCambio = ultimoCambio;
		this.cerrada = cerrada;
		this.preferencias = new ArrayList<Short>();
		
	}

	/**
	 * @return las preferencias
	 */
	public final String[] getPreferencias() {
		return preferencias;
	}

	/**
	 * @param preferencias the preferencias to set
	 */
	public final void setPreferencias(final String[] preferencias) {
		this.preferencias = preferencias;
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
