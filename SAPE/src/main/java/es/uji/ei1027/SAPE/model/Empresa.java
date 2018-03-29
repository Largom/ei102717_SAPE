package es.uji.ei1027.SAPE.model;

public class Empresa extends Personal{

	private String nombre;
	private String cif;
	private String domicilio;
	private int telefonoPrincipal;
	
	
	public Empresa() {
		super();
	}
	public Empresa(String nombre, String cif, String domicilio, int telefonoPrincipal) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.domicilio = domicilio;
		this.telefonoPrincipal = telefonoPrincipal;
	}
	
	public final String getNombre(){return nombre;}
	public final void setNombre(final String otroNombre){ this.nombre = otroNombre;}
	
	public final String getCif(){ return cif;}
	public final void setCif(final String otroCif){ this.cif = otroCif;}
	
	public final String getDomicilio(){ return domicilio;}
	public final void setDomicilio(final String otroDomicilio){ this.domicilio = otroDomicilio;}
	
	public final int getTelefonoPrincipal(){ return telefonoPrincipal;}
	public final void setTelefonoPrincipal(final int tel){ this.telefonoPrincipal = tel;}
	
	@Override
	public String toString(){
		
		return "Datos Empresa: nombre: "+ nombre +", cif: "+ cif +", domicilio: "+ domicilio +", telefono: "+ telefonoPrincipal;
	}
}
