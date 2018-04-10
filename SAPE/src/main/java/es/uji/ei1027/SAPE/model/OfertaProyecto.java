package es.uji.ei1027.SAPE.model;

import java.util.Date;


public class OfertaProyecto{
	
	private short id;
	private String objetivo;
	private String tarea;
	private Date fechaAlta;
	private Date fechaUltimoCambio;
	private MenuEstadoOferta estadoOferta;
	
	/**
	 * 
	 */
	public OfertaProyecto() {
		super();
		this.id = 0;
		this.objetivo = null;
		this.tarea = null;
		this.fechaAlta = null;
		this.fechaUltimoCambio = null;
		this.estadoOferta = MenuEstadoOferta.SINDEFINIR;
	}

	/**
	 * @param id
	 * @param objetivo
	 * @param tarea
	 * @param fechaAlta
	 * @param fechaUltimoCambio
	 * @param estadoOferta
	 */
	public OfertaProyecto(final short id, final String objetivo, final String tarea, final Date fechaAlta,
			final Date fechaUltimoCambio, final MenuEstadoOferta estadoOferta) {
		super();
		this.id = id;
		this.objetivo = objetivo;
		this.tarea = tarea;
		this.fechaAlta = fechaAlta;
		this.fechaUltimoCambio = fechaUltimoCambio;
		this.estadoOferta = estadoOferta;
	}

	/**
	 * @return the objetivo
	 */
	public final String getObjetivo() {
		return objetivo;
	}

	/**
	 * @param objetivo the objetivo to set
	 */
	public final void setObjetivo(final String objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * @return the tarea
	 */
	public final String getTarea() {
		return tarea;
	}

	/**
	 * @param tarea the tarea to set
	 */
	public final void setTarea(final String tarea) {
		this.tarea = tarea;
	}

	/**
	 * @return the fechaAlta
	 */
	public final Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public final void setFechaAlta(final Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the estadoOferta
	 */
	public final MenuEstadoOferta getEstadoOferta() {
		return estadoOferta;
	}

	/**
	 * @param estadoOferta the estadoOferta to set
	 */
	public final void setEstadoOferta(final MenuEstadoOferta estadoOferta) {
		this.estadoOferta = estadoOferta;
	}

	/**
	 * @return the id
	 */
	public final short getId() {
		return id;
	}

	/**
	 * @return the fechaUltimoCambio
	 */
	public final Date getFechaUltimoCambio() {
		return fechaUltimoCambio;
	}
	

}
