package es.uji.ei1027.SAPE.dao;

import java.util.Map;

import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.Itinerario;
import es.uji.ei1027.SAPE.model.Semestre;



public interface DaoEstudiante {
/*
	List<Estudiante> getEstudiantes();
	Estudiante getEstudiante(String usuario);
	void addEstudiante(Estudiante est);
	void updateEstudiante(Estudiante est);
	void deleteEstudiante(String usuario);
*/
	
	/**
	 * Función que extrae los estudiantes en un diccionario con el nombre de usuario como clave.
	 * Lista los estudiantes que el usuario tiene permiso a ver.
	 * @param usu Usuario que desea ver los estudiantes
	 * @param pass Contraseña de usuario
	 * @return Diccionario de estudiantes con su nombre de usuario como clave
	 */
	Map<String, Estudiante> getEstudiantes(final String usu, final String pass);
	
	/**
	 * Función que extrae el estudiante que coincida con el nombre de usuario.
	 * Lista los estudiantes que el usuario tiene permiso a ver.
	 * @param usu Usuario que desea ver el estudiante
	 * @param pass Contraseña de usuario
	 * @param usuario Usuario del estudiente que se desea ver
	 * @return Estudiante del nombre de usuario
	 */
	Estudiante getEstudiante(final String usu, final String pass, final String usuario);
	
	/**
	 * Función que permite al alumno elegir su semestre de realización de proyecto y su Itinerario
	 * @param usu Usuario del estudiante
	 * @param pass Contraseña de usuario
	 * @param semestre Nuevo semestre
	 * @param itinerario Nuevo itinerario
	 * @return True si la operación ha tenido exito
	 */
	boolean elegirSemestreItinerario(final String usu, final String pass, final Semestre semestre, final Itinerario itinerario);
}
