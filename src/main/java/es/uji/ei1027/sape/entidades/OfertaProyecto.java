package es.uji.ei1027.sape.entidades;

import java.util.Date;
import es.uji.ei1027.sape.MenuEstadoOferta;


public class OfertaProyecto {
	
	short id;
	String objetivo;
	String tarea;
	Date fechaAlta;
	Date fechaUltimoCambio;
	MenuEstadoOferta estadoOferta;
	
	
	public OfertaProyecto() {
		super();
	
	}
	public OfertaProyecto(short id, String objetivo, String tarea, Date fechaAlta, Date fechaUltimoCambio) {
		super();
		this.id = id;
		this.objetivo = objetivo;
		this.tarea = tarea;
		this.fechaAlta = fechaAlta;
		this.fechaUltimoCambio = fechaUltimoCambio;
	}
	public final short getId() {return id;}
	public final void setId(short id) {this.id = id;}


	public final String getOjetivo() {return objetivo;}
	public final void setOjetivo(String ojetivo) {this.objetivo = ojetivo;}

	public final String getTarea() {return tarea;}
	public final void setTarea(String tarea) {this.tarea = tarea;}


	public final Date getFechaAlta() {return fechaAlta;}
	public final void setFechaAlta(Date fechaAlta) {this.fechaAlta = fechaAlta;}

	public final Date getFechaUltimoCambio() {return fechaUltimoCambio;}
	public final void setFechaUltimoCambio(Date fechaUltimoCambio) {this.fechaUltimoCambio = fechaUltimoCambio;}


	@Override
	public String toString(){
		
		return "Oferta proyecto: id: "+ id +", objetivo: "+ objetivo +", tarea: "+ tarea +", alta: "+ fechaAlta + ", ultimo cambio: "+ fechaUltimoCambio;
	}
	
	
}
