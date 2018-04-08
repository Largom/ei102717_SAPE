package es.uji.ei1027.SAPE.model;

import java.util.Date;

public class PeticionRevision {
	
	private Date fecha;
	private String textoPeticion;
	
	
	public PeticionRevision() {
		super();
	}


	public PeticionRevision(Date fecha, String textoPeticion) {
		super();
		this.fecha = fecha;
		this.textoPeticion = textoPeticion;
	}


	public final Date getFecha() {return fecha;}
	public final void setFecha(Date fecha) {this.fecha = fecha;}


	public final String getTextoPeticion() {return textoPeticion;}
	public final void setTextoPeticion(String textoPeticion) {this.textoPeticion = textoPeticion;}
		
	

}
