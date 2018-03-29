package es.uji.ei1027.SAPE.model;

//import es.uji.ei1027.SAPE.model.MenuEstadoAsignacion;

import java.util.Date;

public class Asignacion {

	private String id;
	private Date fechaPropuesta;
	private Date fechaCambioEstado;
	private Date fechaTraspasoIGLU;
	private String comentarioPerCambio;
	private MenuEstadoAsignacion estado;
	
	
	
	public Asignacion() {
		super();
		
	}
	public Asignacion(String id, Date fechaPropuesta, Date fechaCambioEstado, Date fechaTraspasoIGLU, String comentarioPerCambio) {
		super();
		this.id = id;
		this.fechaPropuesta = fechaPropuesta;
		this.fechaCambioEstado = fechaCambioEstado;
		this.fechaTraspasoIGLU = fechaTraspasoIGLU;
		this.comentarioPerCambio = comentarioPerCambio;
	}
	
	public final String getId() {return id;}
	public final void setId(String id) {this.id = id;}
	
	public final Date getFechaPropuesta() {return fechaPropuesta;}
	public final void setFechaPropuesta(Date fechaPropuesta) {this.fechaPropuesta = fechaPropuesta;}
	
	public final Date getFechaCambioEstado() {return fechaCambioEstado;}
	public final void setFechaCambioEstado(Date fechaCambioEstado) {this.fechaCambioEstado = fechaCambioEstado;}
	
	public final Date getFechaTraspasoIGLU() {return fechaTraspasoIGLU;}
	public final void setFechaTraspasoIGLU(Date fechaTraspasoIGLU) {this.fechaTraspasoIGLU = fechaTraspasoIGLU;}
	
	public final String getComentarioPerCambio() {return comentarioPerCambio;}
	public final void setComentarioPerCambio(String comentarioPerCambio) {this.comentarioPerCambio = comentarioPerCambio;}
	
	public final MenuEstadoAsignacion getEstado() {return estado;}
	public final void setEstado(MenuEstadoAsignacion estado) {this.estado = estado;}
	
}