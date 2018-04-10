package es.uji.ei1027.SAPE.model;

public class Tutor {
	
	String nombre;
	String correo;
	String despacho;
	String departamento;
	/**
	 * Constructor por defecto de Tutor
	 */
	public Tutor() {
		super();
		this.nombre = null;
		this.correo = null;
		this.despacho = null;
		this.departamento = null;
	}
	/**
	 * Constructor de Tutor con los siguientes parametros:
	 * @param nombre
	 * @param correo
	 * @param despacho
	 * @param departamento
	 */
	public Tutor(final String nombre, final String correo, final String despacho, final String departamento) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.despacho = despacho;
		this.departamento = departamento;
	}
	/**
	 * @return el nombre
	 */
	public final String getNombre() {
		return nombre;
	}
	/**
	 * @return el correo
	 */
	public final String getCorreo() {
		return correo;
	}
	/**
	 * @return el despacho
	 */
	public final String getDespacho() {
		return despacho;
	}
	/**
	 * @return el departamento
	 */
	public final String getDepartamento() {
		return departamento;
	}
	
}