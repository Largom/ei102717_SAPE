package es.uji.ei1027.SAPE.model;

import java.util.Date;

public class Asignacion {

	private short id;
	private short oferta;
	private String estudiante;
	private String tutor;
	private Date fechaPropuesta;
	private Date fechaCambioEstado;
	private Date fechaTraspasoIGLU;
	private String comentarioPerCambio;
	private MenuEstadoAsignacion estado;
	
	public Asignacion() {
		super();
		
	}

	/**
	 * @param id
	 * @param oferta
	 * @param estudiante
	 * @param tutor
	 * @param fechaPropuesta
	 * @param fechaCambioEstado
	 * @param fechaTraspasoIGLU
	 * @param comentarioPerCambio
	 * @param estado
	 */
	public Asignacion(final short id, final short oferta, final String estudiante, final String tutor, final Date fechaPropuesta,
			final Date fechaCambioEstado, final Date fechaTraspasoIGLU, final String comentarioPerCambio, final MenuEstadoAsignacion estado) {
		super();
		this.id = id;
		this.oferta = oferta;
		this.estudiante = estudiante;
		this.tutor = tutor;
		this.fechaPropuesta = fechaPropuesta;
		this.fechaCambioEstado = fechaCambioEstado;
		this.fechaTraspasoIGLU = fechaTraspasoIGLU;
		this.comentarioPerCambio = comentarioPerCambio;
		this.estado = estado;
	}

	/**
	 * @return the oferta
	 */
	public final short getOferta() {
		return oferta;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public final void setOferta(final short oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return the estudiante
	 */
	public final String getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public final void setEstudiante(final String estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the tutor
	 */
	public final String getTutor() {
		return tutor;
	}

	/**
	 * @param tutor the tutor to set
	 */
	public final void setTutor(final String tutor) {
		this.tutor = tutor;
	}

	/**
	 * @return the fechaPropuesta
	 */
	public final Date getFechaPropuesta() {
		return fechaPropuesta;
	}

	/**
	 * @param fechaPropuesta the fechaPropuesta to set
	 */
	public final void setFechaPropuesta(final Date fechaPropuesta) {
		this.fechaPropuesta = fechaPropuesta;
	}

	/**
	 * @return the fechaTraspasoIGLU
	 */
	public final Date getFechaTraspasoIGLU() {
		return fechaTraspasoIGLU;
	}

	/**
	 * @param fechaTraspasoIGLU the fechaTraspasoIGLU to set
	 */
	public final void setFechaTraspasoIGLU(final Date fechaTraspasoIGLU) {
		this.fechaTraspasoIGLU = fechaTraspasoIGLU;
	}

	/**
	 * @return the comentarioPerCambio
	 */
	public final String getComentarioPerCambio() {
		return comentarioPerCambio;
	}

	/**
	 * @param comentarioPerCambio the comentarioPerCambio to set
	 */
	public final void setComentarioPerCambio(final String comentarioPerCambio) {
		this.comentarioPerCambio = comentarioPerCambio;
	}

	/**
	 * @return the estado
	 */
	public final MenuEstadoAsignacion getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public final void setEstado(final MenuEstadoAsignacion estado) {
		this.estado = estado;
	}

	/**
	 * @return the id
	 */
	public final short getId() {
		return id;
	}

	/**
	 * @return the fechaCambioEstado
	 */
	public final Date getFechaCambioEstado() {
		return fechaCambioEstado;
	}
	
}
