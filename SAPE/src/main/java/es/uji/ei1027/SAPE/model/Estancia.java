package es.uji.ei1027.SAPE.model;

public class Estancia {
	
	private short id;
	private String cifEmpresa;
	private String correo;
	private String descripcion;
	private String contactoPersona;
	
	/**
	 * 
	 */
	public Estancia() {
		super();
		
	}

	/**
	 * @param id
	 * @param cifEmpresa
	 * @param correo
	 * @param descripcion
	 * @param contactoPersona
	 */
	public Estancia(final short id, final String cifEmpresa, final String correo, final String descripcion, final String contactoPersona) {
		super();
		this.id = id;
		this.cifEmpresa = cifEmpresa;
		this.correo = correo;
		this.descripcion = descripcion;
		this.contactoPersona = contactoPersona;
	}

	/**
	 * @return the id
	 */
	public final short getId() {
		return id;
	}

	/**
	 * @return the nifEmpresa
	 */
	public final String getNifEmpresa() {
		return cifEmpresa;
	}

	/**
	 * @return the correo
	 */
	public final String getCorreo() {
		return correo;
	}

	/**
	 * @return the descripcion
	 */
	public final String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the contactoPersona
	 */
	public final String getContactoPersona() {
		return contactoPersona;
	}
	
	
	
}
