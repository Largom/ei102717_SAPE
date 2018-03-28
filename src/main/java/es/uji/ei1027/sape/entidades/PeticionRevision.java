import java.util.Date;

public class PeticionRevision {

	Date fecha;
	String descripcion;
	
	public PeticionRevision() {
		super();
	}
	
	public PeticionRevision(Date fecha, String descripcion) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
		
	public final Date getFecha() {return fecha;}
	public final void setFecha(Date fecha) {this.fecha = fecha;}
	
	public final String getDescripcion() {return descripcion;}
	public final void setDescripcion(String descripcion) {this.descripcion = descripcion;}
		
		
}
