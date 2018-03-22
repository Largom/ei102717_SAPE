package es.uji.ei1027.sape.entidades;

public class Estancia {
	
	Short id;
	String correo;
	String descripcion;
	String contactoPersona;
	
	
	public Estancia() {
		super();
		
	}
	public Estancia(Short id, String correo, String descripcion, String contactoPersona) {
		super();
		this.id = id;
		this.correo = correo;
		this.descripcion = descripcion;
		this.contactoPersona = contactoPersona;
	}
	public final Short getId(){return id;}
	public final void setId(Short id){ this.id = id;}
	
	
	public final String getCorreo() { return correo;}
	public final void setCorreo(final String correo){ this.correo = correo;}


	public final String getDescripcion() {return descripcion;}
	public final void setDescripcion(final String descripcion) {this.descripcion = descripcion;}


	public final String getContactoPersona() {return contactoPersona;}
	public final void setContactoPersona(final String contactoPersona) {this.contactoPersona = contactoPersona;}


	
	@Override
	public String toString(){
		
		return "Datos Estancia: id: "+ id +", correo: "+ correo +", descripcion: "+ descripcion +", persona de contacto: "+ contactoPersona;
	}
	
	
}
