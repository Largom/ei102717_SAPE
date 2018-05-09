package es.uji.ei1027.SAPE.model;

public class Personal {
	
	protected String usuario;
	protected String pass;
	
	/**
	 * 
	 */
	public Personal() {
		super();
		this.usuario = null;
		this.pass = null;
	}

	/**
	 * @param usuario
	 * @param pass
	 */
	public Personal(String usuario, String pass) {
		super();
		this.usuario = usuario;
		this.pass = pass;
	}
	
	/**
	 * @return the usuario
	 */
	public final String getUsuario() {
		return usuario;
	}

	/**
	 * @return the pass
	 */
	public final String getPass() {
		return pass;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
}
