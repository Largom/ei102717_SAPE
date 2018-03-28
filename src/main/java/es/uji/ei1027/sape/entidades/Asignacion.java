package es.uji.ei1027.sape.entidades;

import java.util.Date;
import es.uji.ei1027.sape.entidades.MenuEstado;

public class Asignacion {
	
	
	String id;
	Date fechaPropuesta;
	Date fechaCambioEstado;
	Date fechaTraspasoIGLU;
	String comentarioPerCambio;
	MenuEstado estado;
	
	
	
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
	
	public final MenuEstado getEstado() {return estado;}
	public final void setEstado(MenuEstado estado) {this.estado = estado;}

}