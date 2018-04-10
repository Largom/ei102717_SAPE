package es.uji.ei1027.SAPE.model;

public class Empresa extends Personal{

	private String nombre;
	private String cif;
	private String domicilio;
	private String telefonoPrincipal;
	/**
	 * 
	 */
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nombre
	 * @param cif
	 * @param domicilio
	 * @param telefonoPrincipal
	 */
	public Empresa(final String nombre, final String cif, final String domicilio, final String telefonoPrincipal) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.domicilio = domicilio;
		this.telefonoPrincipal = telefonoPrincipal;
	}
	/**
	 * @param usuario
	 * @param pass
	 * @param Empresa
	 */
	public Empresa(final String usuario, final String pass, final Empresa e) {
		super(usuario, pass);
		this.nombre = e.nombre;
		this.cif = e.cif;
		this.domicilio = e.domicilio;
		this.telefonoPrincipal = e.telefonoPrincipal;
	}
	/**
	 * @return the nombre
	 */
	public final String getNombre() {
		return nombre;
	}
	/**
	 * @return the cif
	 */
	public final String getCif() {
		return cif;
	}
	/**
	 * @return the domicilio
	 */
	public final String getDomicilio() {
		return domicilio;
	}
	/**
	 * @return the telefonoPrincipal
	 */
	public final String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}
	
	
	
}
