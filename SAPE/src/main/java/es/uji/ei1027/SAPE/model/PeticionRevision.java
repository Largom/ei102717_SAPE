package es.uji.ei1027.SAPE.model;

import java.util.Date;

public class PeticionRevision {
	
	private short orden;
	private Date fecha;
	private String textoPeticion;
	
	/**
	 * Constructor de Peticion de Revision por defecto
	 */
	public PeticionRevision() {
		super();
		this.orden = 0;
		this.fecha = null;
		this.textoPeticion = null;
	}

	/**
	 * Constructor de Peticion de Revision
	 * @param orden
	 * @param fecha
	 * @param textoPeticion
	 */
	public PeticionRevision(final short orden, final Date fecha, final String textoPeticion) {
		super();
		this.orden = orden;
		this.fecha = fecha;
		this.textoPeticion = textoPeticion;
	}

	/**
	 * @return el textoPeticion
	 */
	public final String getTextoPeticion() {
		return textoPeticion;
	}

	/**
	 * @param textoPeticion the textoPeticion to set
	 */
	public final void setTextoPeticion(final String textoPeticion) {
		this.textoPeticion = textoPeticion;
	}

	/**
	 * @return el orden
	 */
	public final short getOrden() {
		return orden;
	}

	/**
	 * @return the fecha
	 */
	public final Date getFecha() {
		return fecha;
	}
	
}
