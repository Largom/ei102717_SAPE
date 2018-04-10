package es.uji.ei1027.SAPE.dao;

import java.util.List;

import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.MenuItinerario;
import es.uji.ei1027.SAPE.model.MenuSemestre;



public interface DaoEstudiante {
	List<Estudiante> getEstudiantes();
	Estudiante getEstudiante(String usuario);
	void addEstudiante(Estudiante est);
	void updateEstudiante(Estudiante est);
	void deleteEstudiante(String usuario);
	
	List<Estudiante> getEstudiantes(String usu, String pass);
	Estudiante getEstudiante(String usu, String pass, String usuario);
	boolean elegirSemestre(String usu, String pass, MenuSemestre semestre);
	boolean elegirItinerario(String usu, String pass, MenuItinerario itinerario);
}
