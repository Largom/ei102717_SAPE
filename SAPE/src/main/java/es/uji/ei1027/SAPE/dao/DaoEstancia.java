package es.uji.ei1027.SAPE.dao;

import java.util.Map;

import es.uji.ei1027.SAPE.model.Estancia;



public interface DaoEstancia {
/*
	List<Estancia> getEstancias();
	Estancia getEstancia(short id);
	void addEstancia(Estancia esta);
	void updateEstancia(Estancia esta);
	void deleteEstancia(short id);
*/
	/**
	 * Función que extrae las estancias en un diccionario con el id como clave.
	 * Lista las estancias que el usuario tiene permiso a ver.
	 * @param usu Usuario que desea ver las estancias
	 * @param pass Contraseña de usuario
	 * @return Diccionario de estancias con id como clave
	 */
	Map<Short, Estancia> getEstancias(final String usu, final String pass);
	
	/**
	 * Función que extrae la estancia del id indicado.
	 * Muestra las estancias que el usuario tiene permiso a ver.
	 * @param usu Usuario que desea ver la estancia
	 * @param pass Contraseña de usuario
	 * @param id Id de la estancia que se desea buscar
	 * @return Estancia a que tiene el id indicado
	 */
	Estancia getEstancia(final String usu, final String pass, final short id);
}
