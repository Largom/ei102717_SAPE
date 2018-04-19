package es.uji.ei1027.SAPE.dao;


import java.util.Map;

import es.uji.ei1027.SAPE.model.Empresa;



public interface DaoEmpresa {
/*
	List<Empresa> getEmpresas();
	Empresa getEmpresa(String cif);
	void addEmpresa(Empresa emp);
	void updateEmpresa(Empresa emp);
	void deleteEmpresa(String cif);
*/
	
	/**
	 * Función que extrae las empresas en un diccionario con el cif como clave.
	 * Lista las empresas que el usuario tiene permiso a ver.
	 * @param usu Usuario que desea ver las empresas
	 * @param pass Contraseña de usuario
	 * @return Diccionario de empresas con cif como clave
	 */
	Map<String, Empresa> getEmpresas(final String usu, final String pass);
	
	/**
	 * Función que retorna la empresa deseada si tiene permisos para verla
	 * @param usu Usuario que desea ver la empresa
	 * @param pass Contraseña de usuario
	 * @param cif CIF de la empresa que desea ver
	 * @return Empresa del cif o null si no existe o no hay permisos
	 */
	Empresa getEmpresa(final String usu, final String pass, final String cif);
}
