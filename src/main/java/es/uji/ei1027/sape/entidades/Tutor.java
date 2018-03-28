package es.uji.ei1027.sape.entidades;

public class Tutor {
	
	String nombre;
	String correo;
	String despacho;
	String departamento;

	
	
	public Tutor() {
		super();
		
	}

	public Tutor(String nombre, String correo, String despacho, String departamento) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.despacho = despacho;
		this.departamento = departamento;
	}
	
	public final String getNombre() {return nombre;}
	public final void setNombre(String nombre) {this.nombre = nombre;}
	
	public final String getCorreo() {return correo;}
	public final void setCorreo(String correo) {this.correo = correo;}
	
	public final String getDespacho() {return despacho;}
	public final void setDespacho(String despacho) {this.despacho = despacho;}
	
	public final String getDepartamento() {return departamento;}
	public final void setDepartamento(String departamento) {this.departamento = departamento;}
		
	
}
