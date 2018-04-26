package es.uji.ei1027.SAPE.dao;



import java.util.Map;

import es.uji.ei1027.SAPE.model.Asignacion;

public interface DaoAsignacion {
/*
	List<Asignacion> getAsignaciones();
	Asignacion getAsignacion(short id);
	void addAsignacion(Asignacion asig);
	void updateAsignacion(Asignacion asig);
	void deleteAsignacion(short id);
*/
	/**
	 * Función que extrae las asignaciones en un diccionario con el identificador de asignación como key.
	 * Lista las asignaciones que el usuario tiene permiso a ver.
	 * @param usu Usuario que desea ver las asignaciones
	 * @param pass Contraseña de usuario
	 * @return Diccionario de asignaciones con id de asignación como key
	 */
	Map<Short, Asignacion> getAsignaciones(final String usu, final String pass);
	
	/**
	 * Función que retorna la asignación deseada si tiene permisos para verla
	 * @param usu Usuario que desea ver la asignacion
	 * @param pass Contraseña de usuario
	 * @param id Id de la asignación que desea ver
	 * @return Asignacion del id o null si no existe o no hay permisos
	 */
	Asignacion getAsignacion(final String usu, final String pass, final short id);
	
	/**
	 * Función que crea o edita la asignación, si el id es 0 crea una, sino la edita
	 * @param usu Usuario que desea crear o editar la asignacion
	 * @param pass Contraseña de usuario
	 * @param asig Asignación que se va ha editar o crear
	 * @return ID de asignación del elemento creado o editado
	 */
	Short crearEditarAsignacion(final String usu, final String pass, final Asignacion asig);
	
	/**
	 * Función para borrar de forma permanente una asignación
	 * @param usu Usuario que desea anular la asignacion
	 * @param pass Contraseña de usuario
	 * @param id ID de la asignación a borrar o anular
	 * @return Si la función a terminado con exito
	 */
	boolean anularAsignacion(final String usu, final String pass, final short id);
	
	/**
	 * Función para aceptar una asignacion
	 * @param usu Usuario que desea aceptar la asignacion
	 * @param pass Contraseña de usuario
	 * @param id ID de la asignación a aceptar
	 * @return Si la función a terminado con exito
	 */
	boolean aceptaAsignacion(final String usu, final String pass, short id);
	
	/**
	 * Función para rechazar una asignacion
	 * @param usu Usuario que desea rechazar la asignacion
	 * @param pass Contraseña de usuario
	 * @param id ID de la asignación a rechazar
	 * @return Si la función a terminado con exito
	 */
	boolean rechazaAsignacion(final String usu, final String pass, final short id);
	
	/**
	 * Función para solicitar un cambio de asignación una asignacion
	 * @param usu Usuario que desea cambiar la asignacion
	 * @param pass Contraseña de usuario
	 * @param id ID de la asignación a cambiar
	 * @param comentario Comentario de solicitud de cambio de asignación
	 * @return Si la función a terminado con exito
	 */
	boolean petCambioAsignacion(final String usu, final String pass, final short id, final String comentario);
}
